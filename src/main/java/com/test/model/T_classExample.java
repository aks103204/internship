package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class T_classExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public T_classExample() {
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

        public Criteria andCnoIsNull() {
            addCriterion("cno is null");
            return (Criteria) this;
        }

        public Criteria andCnoIsNotNull() {
            addCriterion("cno is not null");
            return (Criteria) this;
        }

        public Criteria andCnoEqualTo(String value) {
            addCriterion("cno =", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotEqualTo(String value) {
            addCriterion("cno <>", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThan(String value) {
            addCriterion("cno >", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThanOrEqualTo(String value) {
            addCriterion("cno >=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThan(String value) {
            addCriterion("cno <", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThanOrEqualTo(String value) {
            addCriterion("cno <=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLike(String value) {
            addCriterion("cno like", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotLike(String value) {
            addCriterion("cno not like", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoIn(List<String> values) {
            addCriterion("cno in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotIn(List<String> values) {
            addCriterion("cno not in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoBetween(String value1, String value2) {
            addCriterion("cno between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotBetween(String value1, String value2) {
            addCriterion("cno not between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andCprofessionIsNull() {
            addCriterion("cprofession is null");
            return (Criteria) this;
        }

        public Criteria andCprofessionIsNotNull() {
            addCriterion("cprofession is not null");
            return (Criteria) this;
        }

        public Criteria andCprofessionEqualTo(String value) {
            addCriterion("cprofession =", value, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionNotEqualTo(String value) {
            addCriterion("cprofession <>", value, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionGreaterThan(String value) {
            addCriterion("cprofession >", value, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionGreaterThanOrEqualTo(String value) {
            addCriterion("cprofession >=", value, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionLessThan(String value) {
            addCriterion("cprofession <", value, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionLessThanOrEqualTo(String value) {
            addCriterion("cprofession <=", value, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionLike(String value) {
            addCriterion("cprofession like", value, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionNotLike(String value) {
            addCriterion("cprofession not like", value, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionIn(List<String> values) {
            addCriterion("cprofession in", values, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionNotIn(List<String> values) {
            addCriterion("cprofession not in", values, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionBetween(String value1, String value2) {
            addCriterion("cprofession between", value1, value2, "cprofession");
            return (Criteria) this;
        }

        public Criteria andCprofessionNotBetween(String value1, String value2) {
            addCriterion("cprofession not between", value1, value2, "cprofession");
            return (Criteria) this;
        }

        public Criteria andTotalpersonIsNull() {
            addCriterion("totalPerson is null");
            return (Criteria) this;
        }

        public Criteria andTotalpersonIsNotNull() {
            addCriterion("totalPerson is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpersonEqualTo(Integer value) {
            addCriterion("totalPerson =", value, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonNotEqualTo(Integer value) {
            addCriterion("totalPerson <>", value, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonGreaterThan(Integer value) {
            addCriterion("totalPerson >", value, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalPerson >=", value, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonLessThan(Integer value) {
            addCriterion("totalPerson <", value, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonLessThanOrEqualTo(Integer value) {
            addCriterion("totalPerson <=", value, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonIn(List<Integer> values) {
            addCriterion("totalPerson in", values, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonNotIn(List<Integer> values) {
            addCriterion("totalPerson not in", values, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonBetween(Integer value1, Integer value2) {
            addCriterion("totalPerson between", value1, value2, "totalperson");
            return (Criteria) this;
        }

        public Criteria andTotalpersonNotBetween(Integer value1, Integer value2) {
            addCriterion("totalPerson not between", value1, value2, "totalperson");
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