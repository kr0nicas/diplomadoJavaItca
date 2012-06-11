package PersistenceClass;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-05-04T16:21:36")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, Short> unitsInStock;
    public static volatile SingularAttribute<Products, Integer> supplierID;
    public static volatile SingularAttribute<Products, Short> unitsOnOrder;
    public static volatile SingularAttribute<Products, String> quantityPerUnit;
    public static volatile SingularAttribute<Products, Short> reorderLevel;
    public static volatile SingularAttribute<Products, Integer> categoryID;
    public static volatile SingularAttribute<Products, BigDecimal> unitPrice;
    public static volatile SingularAttribute<Products, Short> discontinued;
    public static volatile SingularAttribute<Products, Integer> productID;
    public static volatile SingularAttribute<Products, String> productName;

}