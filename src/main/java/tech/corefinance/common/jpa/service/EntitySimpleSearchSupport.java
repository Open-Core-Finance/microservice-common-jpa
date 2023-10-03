package tech.corefinance.common.jpa.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import tech.corefinance.common.model.GenericModel;
import tech.corefinance.common.service.SimpleSearchSupport;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@Repository
@Slf4j
public class EntitySimpleSearchSupport implements SimpleSearchSupport<GenericModel<?>> {

    private Map<EntityType<?>, Set<SingularAttribute<?, ?>>> supportedAttributes;

    public EntitySimpleSearchSupport(@Autowired EntityManager entityManager) {
        supportedAttributes = new HashMap<>();
        var entitiesTypes = entityManager.getMetamodel().getEntities();
        entitiesTypes.forEach(et -> {
            Class<?> entityClass = et.getJavaType();
            log.debug("Scanning attribute of entity class [{}] for SimpleSearchSupport...", entityClass.getName());
            Set<SingularAttribute<?, ?>> attributes = (Set<SingularAttribute<?, ?>>) et.getSingularAttributes();
            Set<SingularAttribute<?, ?>> supportedAttributes = new HashSet<>();
            for (SingularAttribute<?, ?> attribute : attributes) {
                var attributeType = attribute.getJavaType();
                if (attributeType.isEnum() && isEnumSupportSearch(entityClass, attribute)) {
                    supportedAttributes.add(attribute);
                } else if (String.class.isAssignableFrom(attributeType)) {
                    supportedAttributes.add(attribute);
                }
            }
            this.supportedAttributes.put(et, supportedAttributes);
        });
    }

    @Override
    public boolean isSupported(Class<?> clzz) {
        return supportedAttributes.entrySet().stream().filter(e -> e.getKey().getJavaType()
                .isAssignableFrom(clzz)).findFirst().isPresent();
    }

    @Override
    public Page<GenericModel<?>> searchByTextAndPage(Class<? extends GenericModel<?>> clzz, String searchText,
                                                     Pageable pageable) {
        return null;
    }

    @Override
    public List<GenericModel<?>> searchByTextAndSort(Class<? extends GenericModel<?>> clzz, String searchText,
                                                     Sort sort) {
        return null;
    }

    private boolean isEnumSupportSearch(Class<?> entityClass, SingularAttribute<?, ?> attribute) {
        var attributeName = attribute.getName();
        log.debug("Enum Property [{}]", attributeName);

        Field field;
        Method getterMethod;
        try {
            getterMethod = entityClass.getMethod(
                    "get" + attribute.getName().substring(0, 1).toUpperCase() + attribute.getName().substring(1));

            if (getterMethod.isAnnotationPresent(Enumerated.class)) {
                Enumerated enumeratedAnnotation = getterMethod.getAnnotation(Enumerated.class);
                if (enumeratedAnnotation.value() == EnumType.STRING) {
                    log.debug("Method [{}] of class [{}] has annotation Enumerated with EnumType.STRING! This field support search!",
                            getterMethod.getName(), entityClass.getName());
                    return true;
                }
            }

            try {
                field = entityClass.getDeclaredField(attribute.getName());
                if (field.isAnnotationPresent(Enumerated.class)) {
                    Enumerated enumeratedAnnotation = field.getAnnotation(Enumerated.class);
                    if (enumeratedAnnotation.value() == EnumType.STRING) {
                        log.debug("Field [{}] of class [{}] has annotation Enumerated with EnumType.STRING! This field support search!",
                                field.getName(), entityClass.getName());
                        return true;
                    }
                }
            } catch (NoSuchFieldException e1) {
                log.error("Skipped missing field [{}] from class [{}]!", attributeName, entityClass.getName());
            }
        } catch (NoSuchMethodException e) {
            log.error("Error scanning field [{}] from class [{}]", attributeName, entityClass.getName(), e);
        }
        return false;
    }
}
