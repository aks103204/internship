package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class T_registrationExample {

  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public T_registrationExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  public String getOrderByClause() {
    return orderByClause;
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public boolean isDistinct() {
    return distinct;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
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

    public Criteria andRnoIsNull() {
      addCriterion("rno is null");
      return (Criteria) this;
    }

    public Criteria andRnoIsNotNull() {
      addCriterion("rno is not null");
      return (Criteria) this;
    }

    public Criteria andRnoEqualTo(String value) {
      addCriterion("rno =", value, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoNotEqualTo(String value) {
      addCriterion("rno <>", value, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoGreaterThan(String value) {
      addCriterion("rno >", value, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoGreaterThanOrEqualTo(String value) {
      addCriterion("rno >=", value, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoLessThan(String value) {
      addCriterion("rno <", value, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoLessThanOrEqualTo(String value) {
      addCriterion("rno <=", value, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoLike(String value) {
      addCriterion("rno like", value, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoNotLike(String value) {
      addCriterion("rno not like", value, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoIn(List<String> values) {
      addCriterion("rno in", values, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoNotIn(List<String> values) {
      addCriterion("rno not in", values, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoBetween(String value1, String value2) {
      addCriterion("rno between", value1, value2, "rno");
      return (Criteria) this;
    }

    public Criteria andRnoNotBetween(String value1, String value2) {
      addCriterion("rno not between", value1, value2, "rno");
      return (Criteria) this;
    }

    public Criteria andProvinceIsNull() {
      addCriterion("province is null");
      return (Criteria) this;
    }

    public Criteria andProvinceIsNotNull() {
      addCriterion("province is not null");
      return (Criteria) this;
    }

    public Criteria andProvinceEqualTo(String value) {
      addCriterion("province =", value, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceNotEqualTo(String value) {
      addCriterion("province <>", value, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceGreaterThan(String value) {
      addCriterion("province >", value, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceGreaterThanOrEqualTo(String value) {
      addCriterion("province >=", value, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceLessThan(String value) {
      addCriterion("province <", value, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceLessThanOrEqualTo(String value) {
      addCriterion("province <=", value, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceLike(String value) {
      addCriterion("province like", value, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceNotLike(String value) {
      addCriterion("province not like", value, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceIn(List<String> values) {
      addCriterion("province in", values, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceNotIn(List<String> values) {
      addCriterion("province not in", values, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceBetween(String value1, String value2) {
      addCriterion("province between", value1, value2, "province");
      return (Criteria) this;
    }

    public Criteria andProvinceNotBetween(String value1, String value2) {
      addCriterion("province not between", value1, value2, "province");
      return (Criteria) this;
    }

    public Criteria andCityIsNull() {
      addCriterion("city is null");
      return (Criteria) this;
    }

    public Criteria andCityIsNotNull() {
      addCriterion("city is not null");
      return (Criteria) this;
    }

    public Criteria andCityEqualTo(String value) {
      addCriterion("city =", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityNotEqualTo(String value) {
      addCriterion("city <>", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityGreaterThan(String value) {
      addCriterion("city >", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityGreaterThanOrEqualTo(String value) {
      addCriterion("city >=", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityLessThan(String value) {
      addCriterion("city <", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityLessThanOrEqualTo(String value) {
      addCriterion("city <=", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityLike(String value) {
      addCriterion("city like", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityNotLike(String value) {
      addCriterion("city not like", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityIn(List<String> values) {
      addCriterion("city in", values, "city");
      return (Criteria) this;
    }

    public Criteria andCityNotIn(List<String> values) {
      addCriterion("city not in", values, "city");
      return (Criteria) this;
    }

    public Criteria andCityBetween(String value1, String value2) {
      addCriterion("city between", value1, value2, "city");
      return (Criteria) this;
    }

    public Criteria andCityNotBetween(String value1, String value2) {
      addCriterion("city not between", value1, value2, "city");
      return (Criteria) this;
    }

    public Criteria andCompanyIsNull() {
      addCriterion("company is null");
      return (Criteria) this;
    }

    public Criteria andCompanyIsNotNull() {
      addCriterion("company is not null");
      return (Criteria) this;
    }

    public Criteria andCompanyEqualTo(String value) {
      addCriterion("company =", value, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyNotEqualTo(String value) {
      addCriterion("company <>", value, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyGreaterThan(String value) {
      addCriterion("company >", value, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyGreaterThanOrEqualTo(String value) {
      addCriterion("company >=", value, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyLessThan(String value) {
      addCriterion("company <", value, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyLessThanOrEqualTo(String value) {
      addCriterion("company <=", value, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyLike(String value) {
      addCriterion("company like", value, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyNotLike(String value) {
      addCriterion("company not like", value, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyIn(List<String> values) {
      addCriterion("company in", values, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyNotIn(List<String> values) {
      addCriterion("company not in", values, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyBetween(String value1, String value2) {
      addCriterion("company between", value1, value2, "company");
      return (Criteria) this;
    }

    public Criteria andCompanyNotBetween(String value1, String value2) {
      addCriterion("company not between", value1, value2, "company");
      return (Criteria) this;
    }

    public Criteria andLinkmanIsNull() {
      addCriterion("linkman is null");
      return (Criteria) this;
    }

    public Criteria andLinkmanIsNotNull() {
      addCriterion("linkman is not null");
      return (Criteria) this;
    }

    public Criteria andLinkmanEqualTo(String value) {
      addCriterion("linkman =", value, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanNotEqualTo(String value) {
      addCriterion("linkman <>", value, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanGreaterThan(String value) {
      addCriterion("linkman >", value, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
      addCriterion("linkman >=", value, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanLessThan(String value) {
      addCriterion("linkman <", value, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanLessThanOrEqualTo(String value) {
      addCriterion("linkman <=", value, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanLike(String value) {
      addCriterion("linkman like", value, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanNotLike(String value) {
      addCriterion("linkman not like", value, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanIn(List<String> values) {
      addCriterion("linkman in", values, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanNotIn(List<String> values) {
      addCriterion("linkman not in", values, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanBetween(String value1, String value2) {
      addCriterion("linkman between", value1, value2, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanNotBetween(String value1, String value2) {
      addCriterion("linkman not between", value1, value2, "linkman");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneIsNull() {
      addCriterion("linkmanphone is null");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneIsNotNull() {
      addCriterion("linkmanphone is not null");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneEqualTo(String value) {
      addCriterion("linkmanphone =", value, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneNotEqualTo(String value) {
      addCriterion("linkmanphone <>", value, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneGreaterThan(String value) {
      addCriterion("linkmanphone >", value, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneGreaterThanOrEqualTo(String value) {
      addCriterion("linkmanphone >=", value, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneLessThan(String value) {
      addCriterion("linkmanphone <", value, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneLessThanOrEqualTo(String value) {
      addCriterion("linkmanphone <=", value, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneLike(String value) {
      addCriterion("linkmanphone like", value, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneNotLike(String value) {
      addCriterion("linkmanphone not like", value, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneIn(List<String> values) {
      addCriterion("linkmanphone in", values, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneNotIn(List<String> values) {
      addCriterion("linkmanphone not in", values, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneBetween(String value1, String value2) {
      addCriterion("linkmanphone between", value1, value2, "linkmanphone");
      return (Criteria) this;
    }

    public Criteria andLinkmanphoneNotBetween(String value1, String value2) {
      addCriterion("linkmanphone not between", value1, value2, "linkmanphone");
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
  }
}