package com.cs.pojo;

import java.util.ArrayList;
import java.util.List;

public class WorkerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkerExample() {
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

        public Criteria andWidIsNull() {
            addCriterion("wid is null");
            return (Criteria) this;
        }

        public Criteria andWidIsNotNull() {
            addCriterion("wid is not null");
            return (Criteria) this;
        }

        public Criteria andWidEqualTo(Integer value) {
            addCriterion("wid =", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotEqualTo(Integer value) {
            addCriterion("wid <>", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidGreaterThan(Integer value) {
            addCriterion("wid >", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wid >=", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidLessThan(Integer value) {
            addCriterion("wid <", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidLessThanOrEqualTo(Integer value) {
            addCriterion("wid <=", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidIn(List<Integer> values) {
            addCriterion("wid in", values, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotIn(List<Integer> values) {
            addCriterion("wid not in", values, "wid");
            return (Criteria) this;
        }

        public Criteria andWidBetween(Integer value1, Integer value2) {
            addCriterion("wid between", value1, value2, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotBetween(Integer value1, Integer value2) {
            addCriterion("wid not between", value1, value2, "wid");
            return (Criteria) this;
        }

        public Criteria andWnameIsNull() {
            addCriterion("wName is null");
            return (Criteria) this;
        }

        public Criteria andWnameIsNotNull() {
            addCriterion("wName is not null");
            return (Criteria) this;
        }

        public Criteria andWnameEqualTo(String value) {
            addCriterion("wName =", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotEqualTo(String value) {
            addCriterion("wName <>", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameGreaterThan(String value) {
            addCriterion("wName >", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameGreaterThanOrEqualTo(String value) {
            addCriterion("wName >=", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLessThan(String value) {
            addCriterion("wName <", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLessThanOrEqualTo(String value) {
            addCriterion("wName <=", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameLike(String value) {
            addCriterion("wName like", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotLike(String value) {
            addCriterion("wName not like", value, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameIn(List<String> values) {
            addCriterion("wName in", values, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotIn(List<String> values) {
            addCriterion("wName not in", values, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameBetween(String value1, String value2) {
            addCriterion("wName between", value1, value2, "wname");
            return (Criteria) this;
        }

        public Criteria andWnameNotBetween(String value1, String value2) {
            addCriterion("wName not between", value1, value2, "wname");
            return (Criteria) this;
        }

        public Criteria andWdutyIsNull() {
            addCriterion("wDuty is null");
            return (Criteria) this;
        }

        public Criteria andWdutyIsNotNull() {
            addCriterion("wDuty is not null");
            return (Criteria) this;
        }

        public Criteria andWdutyEqualTo(String value) {
            addCriterion("wDuty =", value, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyNotEqualTo(String value) {
            addCriterion("wDuty <>", value, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyGreaterThan(String value) {
            addCriterion("wDuty >", value, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyGreaterThanOrEqualTo(String value) {
            addCriterion("wDuty >=", value, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyLessThan(String value) {
            addCriterion("wDuty <", value, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyLessThanOrEqualTo(String value) {
            addCriterion("wDuty <=", value, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyLike(String value) {
            addCriterion("wDuty like", value, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyNotLike(String value) {
            addCriterion("wDuty not like", value, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyIn(List<String> values) {
            addCriterion("wDuty in", values, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyNotIn(List<String> values) {
            addCriterion("wDuty not in", values, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyBetween(String value1, String value2) {
            addCriterion("wDuty between", value1, value2, "wduty");
            return (Criteria) this;
        }

        public Criteria andWdutyNotBetween(String value1, String value2) {
            addCriterion("wDuty not between", value1, value2, "wduty");
            return (Criteria) this;
        }

        public Criteria andWidfrontIsNull() {
            addCriterion("wIDFront is null");
            return (Criteria) this;
        }

        public Criteria andWidfrontIsNotNull() {
            addCriterion("wIDFront is not null");
            return (Criteria) this;
        }

        public Criteria andWidfrontEqualTo(String value) {
            addCriterion("wIDFront =", value, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontNotEqualTo(String value) {
            addCriterion("wIDFront <>", value, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontGreaterThan(String value) {
            addCriterion("wIDFront >", value, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontGreaterThanOrEqualTo(String value) {
            addCriterion("wIDFront >=", value, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontLessThan(String value) {
            addCriterion("wIDFront <", value, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontLessThanOrEqualTo(String value) {
            addCriterion("wIDFront <=", value, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontLike(String value) {
            addCriterion("wIDFront like", value, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontNotLike(String value) {
            addCriterion("wIDFront not like", value, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontIn(List<String> values) {
            addCriterion("wIDFront in", values, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontNotIn(List<String> values) {
            addCriterion("wIDFront not in", values, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontBetween(String value1, String value2) {
            addCriterion("wIDFront between", value1, value2, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidfrontNotBetween(String value1, String value2) {
            addCriterion("wIDFront not between", value1, value2, "widfront");
            return (Criteria) this;
        }

        public Criteria andWidreverseIsNull() {
            addCriterion("wIDReverse is null");
            return (Criteria) this;
        }

        public Criteria andWidreverseIsNotNull() {
            addCriterion("wIDReverse is not null");
            return (Criteria) this;
        }

        public Criteria andWidreverseEqualTo(String value) {
            addCriterion("wIDReverse =", value, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseNotEqualTo(String value) {
            addCriterion("wIDReverse <>", value, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseGreaterThan(String value) {
            addCriterion("wIDReverse >", value, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseGreaterThanOrEqualTo(String value) {
            addCriterion("wIDReverse >=", value, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseLessThan(String value) {
            addCriterion("wIDReverse <", value, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseLessThanOrEqualTo(String value) {
            addCriterion("wIDReverse <=", value, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseLike(String value) {
            addCriterion("wIDReverse like", value, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseNotLike(String value) {
            addCriterion("wIDReverse not like", value, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseIn(List<String> values) {
            addCriterion("wIDReverse in", values, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseNotIn(List<String> values) {
            addCriterion("wIDReverse not in", values, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseBetween(String value1, String value2) {
            addCriterion("wIDReverse between", value1, value2, "widreverse");
            return (Criteria) this;
        }

        public Criteria andWidreverseNotBetween(String value1, String value2) {
            addCriterion("wIDReverse not between", value1, value2, "widreverse");
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