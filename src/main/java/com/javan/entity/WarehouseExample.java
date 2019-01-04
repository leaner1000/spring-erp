package com.javan.entity;

import java.util.ArrayList;
import java.util.List;

public class WarehouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarehouseExample() {
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

        public Criteria andWarehouse_idIsNull() {
            addCriterion("warehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idIsNotNull() {
            addCriterion("warehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idEqualTo(Integer value) {
            addCriterion("warehouse_id =", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idNotEqualTo(Integer value) {
            addCriterion("warehouse_id <>", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idGreaterThan(Integer value) {
            addCriterion("warehouse_id >", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("warehouse_id >=", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idLessThan(Integer value) {
            addCriterion("warehouse_id <", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idLessThanOrEqualTo(Integer value) {
            addCriterion("warehouse_id <=", value, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idIn(List<Integer> values) {
            addCriterion("warehouse_id in", values, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idNotIn(List<Integer> values) {
            addCriterion("warehouse_id not in", values, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idBetween(Integer value1, Integer value2) {
            addCriterion("warehouse_id between", value1, value2, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andWarehouse_idNotBetween(Integer value1, Integer value2) {
            addCriterion("warehouse_id not between", value1, value2, "warehouse_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployee_idIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployee_idEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idLessThan(Integer value) {
            addCriterion("employee_id <", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_idNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneIsNull() {
            addCriterion("employee_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneIsNotNull() {
            addCriterion("employee_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneEqualTo(String value) {
            addCriterion("employee_phone =", value, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneNotEqualTo(String value) {
            addCriterion("employee_phone <>", value, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneGreaterThan(String value) {
            addCriterion("employee_phone >", value, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("employee_phone >=", value, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneLessThan(String value) {
            addCriterion("employee_phone <", value, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneLessThanOrEqualTo(String value) {
            addCriterion("employee_phone <=", value, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneLike(String value) {
            addCriterion("employee_phone like", value, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneNotLike(String value) {
            addCriterion("employee_phone not like", value, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneIn(List<String> values) {
            addCriterion("employee_phone in", values, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneNotIn(List<String> values) {
            addCriterion("employee_phone not in", values, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneBetween(String value1, String value2) {
            addCriterion("employee_phone between", value1, value2, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andEmployee_phoneNotBetween(String value1, String value2) {
            addCriterion("employee_phone not between", value1, value2, "employee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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