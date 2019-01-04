package com.javan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseExample() {
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

        public Criteria andPurchase_idIsNull() {
            addCriterion("purchase_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchase_idIsNotNull() {
            addCriterion("purchase_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchase_idEqualTo(Integer value) {
            addCriterion("purchase_id =", value, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idNotEqualTo(Integer value) {
            addCriterion("purchase_id <>", value, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idGreaterThan(Integer value) {
            addCriterion("purchase_id >", value, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_id >=", value, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idLessThan(Integer value) {
            addCriterion("purchase_id <", value, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_id <=", value, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idIn(List<Integer> values) {
            addCriterion("purchase_id in", values, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idNotIn(List<Integer> values) {
            addCriterion("purchase_id not in", values, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idBetween(Integer value1, Integer value2) {
            addCriterion("purchase_id between", value1, value2, "purchase_id");
            return (Criteria) this;
        }

        public Criteria andPurchase_idNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_id not between", value1, value2, "purchase_id");
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

        public Criteria andGuest_idEqualTo(String value) {
            addCriterion("guest_id =", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idNotEqualTo(String value) {
            addCriterion("guest_id <>", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idGreaterThan(String value) {
            addCriterion("guest_id >", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idGreaterThanOrEqualTo(String value) {
            addCriterion("guest_id >=", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idLessThan(String value) {
            addCriterion("guest_id <", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idLessThanOrEqualTo(String value) {
            addCriterion("guest_id <=", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idLike(String value) {
            addCriterion("guest_id like", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idNotLike(String value) {
            addCriterion("guest_id not like", value, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idIn(List<String> values) {
            addCriterion("guest_id in", values, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idNotIn(List<String> values) {
            addCriterion("guest_id not in", values, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idBetween(String value1, String value2) {
            addCriterion("guest_id between", value1, value2, "guest_id");
            return (Criteria) this;
        }

        public Criteria andGuest_idNotBetween(String value1, String value2) {
            addCriterion("guest_id not between", value1, value2, "guest_id");
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

        public Criteria andPurchase_dateIsNull() {
            addCriterion("purchase_date is null");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateIsNotNull() {
            addCriterion("purchase_date is not null");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateEqualTo(Date value) {
            addCriterion("purchase_date =", value, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateNotEqualTo(Date value) {
            addCriterion("purchase_date <>", value, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateGreaterThan(Date value) {
            addCriterion("purchase_date >", value, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_date >=", value, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateLessThan(Date value) {
            addCriterion("purchase_date <", value, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateLessThanOrEqualTo(Date value) {
            addCriterion("purchase_date <=", value, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateIn(List<Date> values) {
            addCriterion("purchase_date in", values, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateNotIn(List<Date> values) {
            addCriterion("purchase_date not in", values, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateBetween(Date value1, Date value2) {
            addCriterion("purchase_date between", value1, value2, "purchase_date");
            return (Criteria) this;
        }

        public Criteria andPurchase_dateNotBetween(Date value1, Date value2) {
            addCriterion("purchase_date not between", value1, value2, "purchase_date");
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

        public Criteria andTotal_priceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotal_priceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_priceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "total_price");
            return (Criteria) this;
        }

        public Criteria andTotal_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "total_price");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyIsNull() {
            addCriterion("receive_money is null");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyIsNotNull() {
            addCriterion("receive_money is not null");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyEqualTo(String value) {
            addCriterion("receive_money =", value, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyNotEqualTo(String value) {
            addCriterion("receive_money <>", value, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyGreaterThan(String value) {
            addCriterion("receive_money >", value, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyGreaterThanOrEqualTo(String value) {
            addCriterion("receive_money >=", value, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyLessThan(String value) {
            addCriterion("receive_money <", value, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyLessThanOrEqualTo(String value) {
            addCriterion("receive_money <=", value, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyLike(String value) {
            addCriterion("receive_money like", value, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyNotLike(String value) {
            addCriterion("receive_money not like", value, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyIn(List<String> values) {
            addCriterion("receive_money in", values, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyNotIn(List<String> values) {
            addCriterion("receive_money not in", values, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyBetween(String value1, String value2) {
            addCriterion("receive_money between", value1, value2, "receive_money");
            return (Criteria) this;
        }

        public Criteria andReceive_moneyNotBetween(String value1, String value2) {
            addCriterion("receive_money not between", value1, value2, "receive_money");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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