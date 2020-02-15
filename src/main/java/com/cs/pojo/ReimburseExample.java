package com.cs.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReimburseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReimburseExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRhospitalIsNull() {
            addCriterion("rHospital is null");
            return (Criteria) this;
        }

        public Criteria andRhospitalIsNotNull() {
            addCriterion("rHospital is not null");
            return (Criteria) this;
        }

        public Criteria andRhospitalEqualTo(String value) {
            addCriterion("rHospital =", value, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalNotEqualTo(String value) {
            addCriterion("rHospital <>", value, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalGreaterThan(String value) {
            addCriterion("rHospital >", value, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalGreaterThanOrEqualTo(String value) {
            addCriterion("rHospital >=", value, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalLessThan(String value) {
            addCriterion("rHospital <", value, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalLessThanOrEqualTo(String value) {
            addCriterion("rHospital <=", value, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalLike(String value) {
            addCriterion("rHospital like", value, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalNotLike(String value) {
            addCriterion("rHospital not like", value, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalIn(List<String> values) {
            addCriterion("rHospital in", values, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalNotIn(List<String> values) {
            addCriterion("rHospital not in", values, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalBetween(String value1, String value2) {
            addCriterion("rHospital between", value1, value2, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalNotBetween(String value1, String value2) {
            addCriterion("rHospital not between", value1, value2, "rhospital");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceIsNull() {
            addCriterion("rHospitalInvoice is null");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceIsNotNull() {
            addCriterion("rHospitalInvoice is not null");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceEqualTo(String value) {
            addCriterion("rHospitalInvoice =", value, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceNotEqualTo(String value) {
            addCriterion("rHospitalInvoice <>", value, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceGreaterThan(String value) {
            addCriterion("rHospitalInvoice >", value, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("rHospitalInvoice >=", value, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceLessThan(String value) {
            addCriterion("rHospitalInvoice <", value, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceLessThanOrEqualTo(String value) {
            addCriterion("rHospitalInvoice <=", value, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceLike(String value) {
            addCriterion("rHospitalInvoice like", value, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceNotLike(String value) {
            addCriterion("rHospitalInvoice not like", value, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceIn(List<String> values) {
            addCriterion("rHospitalInvoice in", values, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceNotIn(List<String> values) {
            addCriterion("rHospitalInvoice not in", values, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceBetween(String value1, String value2) {
            addCriterion("rHospitalInvoice between", value1, value2, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRhospitalinvoiceNotBetween(String value1, String value2) {
            addCriterion("rHospitalInvoice not between", value1, value2, "rhospitalinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyIsNull() {
            addCriterion("rMoney is null");
            return (Criteria) this;
        }

        public Criteria andRmoneyIsNotNull() {
            addCriterion("rMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRmoneyEqualTo(String value) {
            addCriterion("rMoney =", value, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyNotEqualTo(String value) {
            addCriterion("rMoney <>", value, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyGreaterThan(String value) {
            addCriterion("rMoney >", value, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("rMoney >=", value, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyLessThan(String value) {
            addCriterion("rMoney <", value, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyLessThanOrEqualTo(String value) {
            addCriterion("rMoney <=", value, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyLike(String value) {
            addCriterion("rMoney like", value, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyNotLike(String value) {
            addCriterion("rMoney not like", value, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyIn(List<String> values) {
            addCriterion("rMoney in", values, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyNotIn(List<String> values) {
            addCriterion("rMoney not in", values, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyBetween(String value1, String value2) {
            addCriterion("rMoney between", value1, value2, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyNotBetween(String value1, String value2) {
            addCriterion("rMoney not between", value1, value2, "rmoney");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceIsNull() {
            addCriterion("rMoneyInvoice is null");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceIsNotNull() {
            addCriterion("rMoneyInvoice is not null");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceEqualTo(String value) {
            addCriterion("rMoneyInvoice =", value, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceNotEqualTo(String value) {
            addCriterion("rMoneyInvoice <>", value, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceGreaterThan(String value) {
            addCriterion("rMoneyInvoice >", value, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("rMoneyInvoice >=", value, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceLessThan(String value) {
            addCriterion("rMoneyInvoice <", value, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceLessThanOrEqualTo(String value) {
            addCriterion("rMoneyInvoice <=", value, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceLike(String value) {
            addCriterion("rMoneyInvoice like", value, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceNotLike(String value) {
            addCriterion("rMoneyInvoice not like", value, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceIn(List<String> values) {
            addCriterion("rMoneyInvoice in", values, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceNotIn(List<String> values) {
            addCriterion("rMoneyInvoice not in", values, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceBetween(String value1, String value2) {
            addCriterion("rMoneyInvoice between", value1, value2, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRmoneyinvoiceNotBetween(String value1, String value2) {
            addCriterion("rMoneyInvoice not between", value1, value2, "rmoneyinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveIsNull() {
            addCriterion("rProve is null");
            return (Criteria) this;
        }

        public Criteria andRproveIsNotNull() {
            addCriterion("rProve is not null");
            return (Criteria) this;
        }

        public Criteria andRproveEqualTo(Integer value) {
            addCriterion("rProve =", value, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveNotEqualTo(Integer value) {
            addCriterion("rProve <>", value, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveGreaterThan(Integer value) {
            addCriterion("rProve >", value, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveGreaterThanOrEqualTo(Integer value) {
            addCriterion("rProve >=", value, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveLessThan(Integer value) {
            addCriterion("rProve <", value, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveLessThanOrEqualTo(Integer value) {
            addCriterion("rProve <=", value, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveIn(List<Integer> values) {
            addCriterion("rProve in", values, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveNotIn(List<Integer> values) {
            addCriterion("rProve not in", values, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveBetween(Integer value1, Integer value2) {
            addCriterion("rProve between", value1, value2, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveNotBetween(Integer value1, Integer value2) {
            addCriterion("rProve not between", value1, value2, "rprove");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceIsNull() {
            addCriterion("rProveInvoice is null");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceIsNotNull() {
            addCriterion("rProveInvoice is not null");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceEqualTo(String value) {
            addCriterion("rProveInvoice =", value, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceNotEqualTo(String value) {
            addCriterion("rProveInvoice <>", value, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceGreaterThan(String value) {
            addCriterion("rProveInvoice >", value, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("rProveInvoice >=", value, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceLessThan(String value) {
            addCriterion("rProveInvoice <", value, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceLessThanOrEqualTo(String value) {
            addCriterion("rProveInvoice <=", value, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceLike(String value) {
            addCriterion("rProveInvoice like", value, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceNotLike(String value) {
            addCriterion("rProveInvoice not like", value, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceIn(List<String> values) {
            addCriterion("rProveInvoice in", values, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceNotIn(List<String> values) {
            addCriterion("rProveInvoice not in", values, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceBetween(String value1, String value2) {
            addCriterion("rProveInvoice between", value1, value2, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRproveinvoiceNotBetween(String value1, String value2) {
            addCriterion("rProveInvoice not between", value1, value2, "rproveinvoice");
            return (Criteria) this;
        }

        public Criteria andRtimeIsNull() {
            addCriterion("rTime is null");
            return (Criteria) this;
        }

        public Criteria andRtimeIsNotNull() {
            addCriterion("rTime is not null");
            return (Criteria) this;
        }

        public Criteria andRtimeEqualTo(Date value) {
            addCriterionForJDBCDate("rTime =", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("rTime <>", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("rTime >", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rTime >=", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLessThan(Date value) {
            addCriterionForJDBCDate("rTime <", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rTime <=", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeIn(List<Date> values) {
            addCriterionForJDBCDate("rTime in", values, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("rTime not in", values, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rTime between", value1, value2, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rTime not between", value1, value2, "rtime");
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