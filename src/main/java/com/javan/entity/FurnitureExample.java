package com.javan.entity;

import java.util.ArrayList;
import java.util.List;

public class FurnitureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FurnitureExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFurniture_idIsNull() {
            addCriterion("furniture_id is null");
            return (Criteria) this;
        }

        public Criteria andFurniture_idIsNotNull() {
            addCriterion("furniture_id is not null");
            return (Criteria) this;
        }

        public Criteria andFurniture_idEqualTo(Integer value) {
            addCriterion("furniture_id =", value, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idNotEqualTo(Integer value) {
            addCriterion("furniture_id <>", value, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idGreaterThan(Integer value) {
            addCriterion("furniture_id >", value, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("furniture_id >=", value, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idLessThan(Integer value) {
            addCriterion("furniture_id <", value, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idLessThanOrEqualTo(Integer value) {
            addCriterion("furniture_id <=", value, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idIn(List<Integer> values) {
            addCriterion("furniture_id in", values, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idNotIn(List<Integer> values) {
            addCriterion("furniture_id not in", values, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idBetween(Integer value1, Integer value2) {
            addCriterion("furniture_id between", value1, value2, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_idNotBetween(Integer value1, Integer value2) {
            addCriterion("furniture_id not between", value1, value2, "furniture_id");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameIsNull() {
            addCriterion("furniture_name is null");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameIsNotNull() {
            addCriterion("furniture_name is not null");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameEqualTo(String value) {
            addCriterion("furniture_name =", value, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameNotEqualTo(String value) {
            addCriterion("furniture_name <>", value, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameGreaterThan(String value) {
            addCriterion("furniture_name >", value, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameGreaterThanOrEqualTo(String value) {
            addCriterion("furniture_name >=", value, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameLessThan(String value) {
            addCriterion("furniture_name <", value, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameLessThanOrEqualTo(String value) {
            addCriterion("furniture_name <=", value, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameLike(String value) {
            addCriterion("furniture_name like", value, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameNotLike(String value) {
            addCriterion("furniture_name not like", value, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameIn(List<String> values) {
            addCriterion("furniture_name in", values, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameNotIn(List<String> values) {
            addCriterion("furniture_name not in", values, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameBetween(String value1, String value2) {
            addCriterion("furniture_name between", value1, value2, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_nameNotBetween(String value1, String value2) {
            addCriterion("furniture_name not between", value1, value2, "furniture_name");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionIsNull() {
            addCriterion("furniture_discription is null");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionIsNotNull() {
            addCriterion("furniture_discription is not null");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionEqualTo(String value) {
            addCriterion("furniture_discription =", value, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionNotEqualTo(String value) {
            addCriterion("furniture_discription <>", value, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionGreaterThan(String value) {
            addCriterion("furniture_discription >", value, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionGreaterThanOrEqualTo(String value) {
            addCriterion("furniture_discription >=", value, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionLessThan(String value) {
            addCriterion("furniture_discription <", value, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionLessThanOrEqualTo(String value) {
            addCriterion("furniture_discription <=", value, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionLike(String value) {
            addCriterion("furniture_discription like", value, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionNotLike(String value) {
            addCriterion("furniture_discription not like", value, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionIn(List<String> values) {
            addCriterion("furniture_discription in", values, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionNotIn(List<String> values) {
            addCriterion("furniture_discription not in", values, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionBetween(String value1, String value2) {
            addCriterion("furniture_discription between", value1, value2, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andFurniture_discriptionNotBetween(String value1, String value2) {
            addCriterion("furniture_discription not between", value1, value2, "furniture_discription");
            return (Criteria) this;
        }

        public Criteria andPicture_pathIsNull() {
            addCriterion("picture_path is null");
            return (Criteria) this;
        }

        public Criteria andPicture_pathIsNotNull() {
            addCriterion("picture_path is not null");
            return (Criteria) this;
        }

        public Criteria andPicture_pathEqualTo(String value) {
            addCriterion("picture_path =", value, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathNotEqualTo(String value) {
            addCriterion("picture_path <>", value, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathGreaterThan(String value) {
            addCriterion("picture_path >", value, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathGreaterThanOrEqualTo(String value) {
            addCriterion("picture_path >=", value, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathLessThan(String value) {
            addCriterion("picture_path <", value, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathLessThanOrEqualTo(String value) {
            addCriterion("picture_path <=", value, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathLike(String value) {
            addCriterion("picture_path like", value, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathNotLike(String value) {
            addCriterion("picture_path not like", value, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathIn(List<String> values) {
            addCriterion("picture_path in", values, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathNotIn(List<String> values) {
            addCriterion("picture_path not in", values, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathBetween(String value1, String value2) {
            addCriterion("picture_path between", value1, value2, "picture_path");
            return (Criteria) this;
        }

        public Criteria andPicture_pathNotBetween(String value1, String value2) {
            addCriterion("picture_path not between", value1, value2, "picture_path");
            return (Criteria) this;
        }

        public Criteria andProviderIsNull() {
            addCriterion("provider is null");
            return (Criteria) this;
        }

        public Criteria andProviderIsNotNull() {
            addCriterion("provider is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEqualTo(String value) {
            addCriterion("provider =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(String value) {
            addCriterion("provider <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(String value) {
            addCriterion("provider >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(String value) {
            addCriterion("provider >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(String value) {
            addCriterion("provider <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(String value) {
            addCriterion("provider <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLike(String value) {
            addCriterion("provider like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotLike(String value) {
            addCriterion("provider not like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(List<String> values) {
            addCriterion("provider in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(List<String> values) {
            addCriterion("provider not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(String value1, String value2) {
            addCriterion("provider between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(String value1, String value2) {
            addCriterion("provider not between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idIsNull() {
            addCriterion("warehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idIsNotNull() {
            addCriterion("warehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idEqualTo(String value) {
            addCriterion("warehouse_id =", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idNotEqualTo(String value) {
            addCriterion("warehouse_id <>", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idGreaterThan(String value) {
            addCriterion("warehouse_id >", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_id >=", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idLessThan(String value) {
            addCriterion("warehouse_id <", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idLessThanOrEqualTo(String value) {
            addCriterion("warehouse_id <=", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idLike(String value) {
            addCriterion("warehouse_id like", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idNotLike(String value) {
            addCriterion("warehouse_id not like", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idIn(List<String> values) {
            addCriterion("warehouse_id in", values, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idNotIn(List<String> values) {
            addCriterion("warehouse_id not in", values, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idBetween(String value1, String value2) {
            addCriterion("warehouse_id between", value1, value2, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idNotBetween(String value1, String value2) {
            addCriterion("warehouse_id not between", value1, value2, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}