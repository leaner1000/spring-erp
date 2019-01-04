package com.javan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairExample() {
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

        public Criteria andRepair_idIsNull() {
            addCriterion("repair_id is null");
            return (Criteria) this;
        }

        public Criteria andRepair_idIsNotNull() {
            addCriterion("repair_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepair_idEqualTo(Integer value) {
            addCriterion("repair_id =", value, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idNotEqualTo(Integer value) {
            addCriterion("repair_id <>", value, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idGreaterThan(Integer value) {
            addCriterion("repair_id >", value, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_id >=", value, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idLessThan(Integer value) {
            addCriterion("repair_id <", value, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idLessThanOrEqualTo(Integer value) {
            addCriterion("repair_id <=", value, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idIn(List<Integer> values) {
            addCriterion("repair_id in", values, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idNotIn(List<Integer> values) {
            addCriterion("repair_id not in", values, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idBetween(Integer value1, Integer value2) {
            addCriterion("repair_id between", value1, value2, "repair_id");
            return (Criteria) this;
        }

        public Criteria andRepair_idNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_id not between", value1, value2, "repair_id");
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

        public Criteria andDamage_conditionIsNull() {
            addCriterion("damage_condition is null");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionIsNotNull() {
            addCriterion("damage_condition is not null");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionEqualTo(String value) {
            addCriterion("damage_condition =", value, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionNotEqualTo(String value) {
            addCriterion("damage_condition <>", value, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionGreaterThan(String value) {
            addCriterion("damage_condition >", value, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionGreaterThanOrEqualTo(String value) {
            addCriterion("damage_condition >=", value, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionLessThan(String value) {
            addCriterion("damage_condition <", value, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionLessThanOrEqualTo(String value) {
            addCriterion("damage_condition <=", value, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionLike(String value) {
            addCriterion("damage_condition like", value, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionNotLike(String value) {
            addCriterion("damage_condition not like", value, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionIn(List<String> values) {
            addCriterion("damage_condition in", values, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionNotIn(List<String> values) {
            addCriterion("damage_condition not in", values, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionBetween(String value1, String value2) {
            addCriterion("damage_condition between", value1, value2, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andDamage_conditionNotBetween(String value1, String value2) {
            addCriterion("damage_condition not between", value1, value2, "damage_condition");
            return (Criteria) this;
        }

        public Criteria andSend_dateIsNull() {
            addCriterion("send_date is null");
            return (Criteria) this;
        }

        public Criteria andSend_dateIsNotNull() {
            addCriterion("send_date is not null");
            return (Criteria) this;
        }

        public Criteria andSend_dateEqualTo(Date value) {
            addCriterion("send_date =", value, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateNotEqualTo(Date value) {
            addCriterion("send_date <>", value, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateGreaterThan(Date value) {
            addCriterion("send_date >", value, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("send_date >=", value, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateLessThan(Date value) {
            addCriterion("send_date <", value, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateLessThanOrEqualTo(Date value) {
            addCriterion("send_date <=", value, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateIn(List<Date> values) {
            addCriterion("send_date in", values, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateNotIn(List<Date> values) {
            addCriterion("send_date not in", values, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateBetween(Date value1, Date value2) {
            addCriterion("send_date between", value1, value2, "send_date");
            return (Criteria) this;
        }

        public Criteria andSend_dateNotBetween(Date value1, Date value2) {
            addCriterion("send_date not between", value1, value2, "send_date");
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

        public Criteria andGuest_idIsNull() {
            addCriterion("guest_id is null");
            return (Criteria) this;
        }

        public Criteria andGuest_idIsNotNull() {
            addCriterion("guest_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuest_idEqualTo(Integer value) {
            addCriterion("guest_id =", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idNotEqualTo(Integer value) {
            addCriterion("guest_id <>", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idGreaterThan(Integer value) {
            addCriterion("guest_id >", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("guest_id >=", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idLessThan(Integer value) {
            addCriterion("guest_id <", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idLessThanOrEqualTo(Integer value) {
            addCriterion("guest_id <=", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idIn(List<Integer> values) {
            addCriterion("guest_id in", values, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idNotIn(List<Integer> values) {
            addCriterion("guest_id not in", values, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idBetween(Integer value1, Integer value2) {
            addCriterion("guest_id between", value1, value2, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idNotBetween(Integer value1, Integer value2) {
            addCriterion("guest_id not between", value1, value2, "guest_id");
            return (Criteria) this;
        }

        public Criteria andRepair_stateIsNull() {
            addCriterion("repair_state is null");
            return (Criteria) this;
        }

        public Criteria andRepair_stateIsNotNull() {
            addCriterion("repair_state is not null");
            return (Criteria) this;
        }

        public Criteria andRepair_stateEqualTo(String value) {
            addCriterion("repair_state =", value, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateNotEqualTo(String value) {
            addCriterion("repair_state <>", value, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateGreaterThan(String value) {
            addCriterion("repair_state >", value, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateGreaterThanOrEqualTo(String value) {
            addCriterion("repair_state >=", value, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateLessThan(String value) {
            addCriterion("repair_state <", value, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateLessThanOrEqualTo(String value) {
            addCriterion("repair_state <=", value, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateLike(String value) {
            addCriterion("repair_state like", value, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateNotLike(String value) {
            addCriterion("repair_state not like", value, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateIn(List<String> values) {
            addCriterion("repair_state in", values, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateNotIn(List<String> values) {
            addCriterion("repair_state not in", values, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateBetween(String value1, String value2) {
            addCriterion("repair_state between", value1, value2, "repair_state");
            return (Criteria) this;
        }

        public Criteria andRepair_stateNotBetween(String value1, String value2) {
            addCriterion("repair_state not between", value1, value2, "repair_state");
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

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
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