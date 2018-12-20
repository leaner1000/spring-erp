package com.javan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutBoundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutBoundExample() {
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

        public Criteria andOutbound_idIsNull() {
            addCriterion("outbound_id is null");
            return (Criteria) this;
        }

        public Criteria andOutbound_idIsNotNull() {
            addCriterion("outbound_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutbound_idEqualTo(Integer value) {
            addCriterion("outbound_id =", value, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idNotEqualTo(Integer value) {
            addCriterion("outbound_id <>", value, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idGreaterThan(Integer value) {
            addCriterion("outbound_id >", value, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("outbound_id >=", value, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idLessThan(Integer value) {
            addCriterion("outbound_id <", value, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idLessThanOrEqualTo(Integer value) {
            addCriterion("outbound_id <=", value, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idIn(List<Integer> values) {
            addCriterion("outbound_id in", values, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idNotIn(List<Integer> values) {
            addCriterion("outbound_id not in", values, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idBetween(Integer value1, Integer value2) {
            addCriterion("outbound_id between", value1, value2, "outbound_id");
            return (Criteria) this;
        }

        public Criteria andOutbound_idNotBetween(Integer value1, Integer value2) {
            addCriterion("outbound_id not between", value1, value2, "outbound_id");
            return (Criteria) this;
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
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