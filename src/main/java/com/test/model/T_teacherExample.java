package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class T_teacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public T_teacherExample() {
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

        public Criteria andTnoIsNull() {
            addCriterion("tno is null");
            return (Criteria) this;
        }

        public Criteria andTnoIsNotNull() {
            addCriterion("tno is not null");
            return (Criteria) this;
        }

        public Criteria andTnoEqualTo(String value) {
            addCriterion("tno =", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotEqualTo(String value) {
            addCriterion("tno <>", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThan(String value) {
            addCriterion("tno >", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThanOrEqualTo(String value) {
            addCriterion("tno >=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThan(String value) {
            addCriterion("tno <", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThanOrEqualTo(String value) {
            addCriterion("tno <=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLike(String value) {
            addCriterion("tno like", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotLike(String value) {
            addCriterion("tno not like", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoIn(List<String> values) {
            addCriterion("tno in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotIn(List<String> values) {
            addCriterion("tno not in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoBetween(String value1, String value2) {
            addCriterion("tno between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotBetween(String value1, String value2) {
            addCriterion("tno not between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTpsdIsNull() {
            addCriterion("tpsd is null");
            return (Criteria) this;
        }

        public Criteria andTpsdIsNotNull() {
            addCriterion("tpsd is not null");
            return (Criteria) this;
        }

        public Criteria andTpsdEqualTo(String value) {
            addCriterion("tpsd =", value, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdNotEqualTo(String value) {
            addCriterion("tpsd <>", value, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdGreaterThan(String value) {
            addCriterion("tpsd >", value, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdGreaterThanOrEqualTo(String value) {
            addCriterion("tpsd >=", value, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdLessThan(String value) {
            addCriterion("tpsd <", value, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdLessThanOrEqualTo(String value) {
            addCriterion("tpsd <=", value, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdLike(String value) {
            addCriterion("tpsd like", value, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdNotLike(String value) {
            addCriterion("tpsd not like", value, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdIn(List<String> values) {
            addCriterion("tpsd in", values, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdNotIn(List<String> values) {
            addCriterion("tpsd not in", values, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdBetween(String value1, String value2) {
            addCriterion("tpsd between", value1, value2, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTpsdNotBetween(String value1, String value2) {
            addCriterion("tpsd not between", value1, value2, "tpsd");
            return (Criteria) this;
        }

        public Criteria andTnameIsNull() {
            addCriterion("tname is null");
            return (Criteria) this;
        }

        public Criteria andTnameIsNotNull() {
            addCriterion("tname is not null");
            return (Criteria) this;
        }

        public Criteria andTnameEqualTo(String value) {
            addCriterion("tname =", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotEqualTo(String value) {
            addCriterion("tname <>", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThan(String value) {
            addCriterion("tname >", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThanOrEqualTo(String value) {
            addCriterion("tname >=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThan(String value) {
            addCriterion("tname <", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThanOrEqualTo(String value) {
            addCriterion("tname <=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLike(String value) {
            addCriterion("tname like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotLike(String value) {
            addCriterion("tname not like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameIn(List<String> values) {
            addCriterion("tname in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotIn(List<String> values) {
            addCriterion("tname not in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameBetween(String value1, String value2) {
            addCriterion("tname between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotBetween(String value1, String value2) {
            addCriterion("tname not between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTphoneIsNull() {
            addCriterion("tphone is null");
            return (Criteria) this;
        }

        public Criteria andTphoneIsNotNull() {
            addCriterion("tphone is not null");
            return (Criteria) this;
        }

        public Criteria andTphoneEqualTo(String value) {
            addCriterion("tphone =", value, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneNotEqualTo(String value) {
            addCriterion("tphone <>", value, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneGreaterThan(String value) {
            addCriterion("tphone >", value, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneGreaterThanOrEqualTo(String value) {
            addCriterion("tphone >=", value, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneLessThan(String value) {
            addCriterion("tphone <", value, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneLessThanOrEqualTo(String value) {
            addCriterion("tphone <=", value, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneLike(String value) {
            addCriterion("tphone like", value, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneNotLike(String value) {
            addCriterion("tphone not like", value, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneIn(List<String> values) {
            addCriterion("tphone in", values, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneNotIn(List<String> values) {
            addCriterion("tphone not in", values, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneBetween(String value1, String value2) {
            addCriterion("tphone between", value1, value2, "tphone");
            return (Criteria) this;
        }

        public Criteria andTphoneNotBetween(String value1, String value2) {
            addCriterion("tphone not between", value1, value2, "tphone");
            return (Criteria) this;
        }

        public Criteria andTqqIsNull() {
            addCriterion("tqq is null");
            return (Criteria) this;
        }

        public Criteria andTqqIsNotNull() {
            addCriterion("tqq is not null");
            return (Criteria) this;
        }

        public Criteria andTqqEqualTo(String value) {
            addCriterion("tqq =", value, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqNotEqualTo(String value) {
            addCriterion("tqq <>", value, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqGreaterThan(String value) {
            addCriterion("tqq >", value, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqGreaterThanOrEqualTo(String value) {
            addCriterion("tqq >=", value, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqLessThan(String value) {
            addCriterion("tqq <", value, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqLessThanOrEqualTo(String value) {
            addCriterion("tqq <=", value, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqLike(String value) {
            addCriterion("tqq like", value, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqNotLike(String value) {
            addCriterion("tqq not like", value, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqIn(List<String> values) {
            addCriterion("tqq in", values, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqNotIn(List<String> values) {
            addCriterion("tqq not in", values, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqBetween(String value1, String value2) {
            addCriterion("tqq between", value1, value2, "tqq");
            return (Criteria) this;
        }

        public Criteria andTqqNotBetween(String value1, String value2) {
            addCriterion("tqq not between", value1, value2, "tqq");
            return (Criteria) this;
        }

        public Criteria andTprofessionIsNull() {
            addCriterion("tprofession is null");
            return (Criteria) this;
        }

        public Criteria andTprofessionIsNotNull() {
            addCriterion("tprofession is not null");
            return (Criteria) this;
        }

        public Criteria andTprofessionEqualTo(String value) {
            addCriterion("tprofession =", value, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionNotEqualTo(String value) {
            addCriterion("tprofession <>", value, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionGreaterThan(String value) {
            addCriterion("tprofession >", value, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionGreaterThanOrEqualTo(String value) {
            addCriterion("tprofession >=", value, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionLessThan(String value) {
            addCriterion("tprofession <", value, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionLessThanOrEqualTo(String value) {
            addCriterion("tprofession <=", value, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionLike(String value) {
            addCriterion("tprofession like", value, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionNotLike(String value) {
            addCriterion("tprofession not like", value, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionIn(List<String> values) {
            addCriterion("tprofession in", values, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionNotIn(List<String> values) {
            addCriterion("tprofession not in", values, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionBetween(String value1, String value2) {
            addCriterion("tprofession between", value1, value2, "tprofession");
            return (Criteria) this;
        }

        public Criteria andTprofessionNotBetween(String value1, String value2) {
            addCriterion("tprofession not between", value1, value2, "tprofession");
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