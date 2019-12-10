package com.test.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {

  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public TaskExample() {
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

    public Criteria andTaskNoIsNull() {
      addCriterion("task_no is null");
      return (Criteria) this;
    }

    public Criteria andTaskNoIsNotNull() {
      addCriterion("task_no is not null");
      return (Criteria) this;
    }

    public Criteria andTaskNoEqualTo(Integer value) {
      addCriterion("task_no =", value, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoNotEqualTo(Integer value) {
      addCriterion("task_no <>", value, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoGreaterThan(Integer value) {
      addCriterion("task_no >", value, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoGreaterThanOrEqualTo(Integer value) {
      addCriterion("task_no >=", value, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoLessThan(Integer value) {
      addCriterion("task_no <", value, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoLessThanOrEqualTo(Integer value) {
      addCriterion("task_no <=", value, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoIn(List<Integer> values) {
      addCriterion("task_no in", values, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoNotIn(List<Integer> values) {
      addCriterion("task_no not in", values, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoBetween(Integer value1, Integer value2) {
      addCriterion("task_no between", value1, value2, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNoNotBetween(Integer value1, Integer value2) {
      addCriterion("task_no not between", value1, value2, "taskNo");
      return (Criteria) this;
    }

    public Criteria andTaskNameIsNull() {
      addCriterion("task_name is null");
      return (Criteria) this;
    }

    public Criteria andTaskNameIsNotNull() {
      addCriterion("task_name is not null");
      return (Criteria) this;
    }

    public Criteria andTaskNameEqualTo(String value) {
      addCriterion("task_name =", value, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameNotEqualTo(String value) {
      addCriterion("task_name <>", value, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameGreaterThan(String value) {
      addCriterion("task_name >", value, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
      addCriterion("task_name >=", value, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameLessThan(String value) {
      addCriterion("task_name <", value, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameLessThanOrEqualTo(String value) {
      addCriterion("task_name <=", value, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameLike(String value) {
      addCriterion("task_name like", value, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameNotLike(String value) {
      addCriterion("task_name not like", value, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameIn(List<String> values) {
      addCriterion("task_name in", values, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameNotIn(List<String> values) {
      addCriterion("task_name not in", values, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameBetween(String value1, String value2) {
      addCriterion("task_name between", value1, value2, "taskName");
      return (Criteria) this;
    }

    public Criteria andTaskNameNotBetween(String value1, String value2) {
      addCriterion("task_name not between", value1, value2, "taskName");
      return (Criteria) this;
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

    public Criteria andTaskContentIsNull() {
      addCriterion("task_content is null");
      return (Criteria) this;
    }

    public Criteria andTaskContentIsNotNull() {
      addCriterion("task_content is not null");
      return (Criteria) this;
    }

    public Criteria andTaskContentEqualTo(String value) {
      addCriterion("task_content =", value, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentNotEqualTo(String value) {
      addCriterion("task_content <>", value, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentGreaterThan(String value) {
      addCriterion("task_content >", value, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
      addCriterion("task_content >=", value, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentLessThan(String value) {
      addCriterion("task_content <", value, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentLessThanOrEqualTo(String value) {
      addCriterion("task_content <=", value, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentLike(String value) {
      addCriterion("task_content like", value, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentNotLike(String value) {
      addCriterion("task_content not like", value, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentIn(List<String> values) {
      addCriterion("task_content in", values, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentNotIn(List<String> values) {
      addCriterion("task_content not in", values, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentBetween(String value1, String value2) {
      addCriterion("task_content between", value1, value2, "taskContent");
      return (Criteria) this;
    }

    public Criteria andTaskContentNotBetween(String value1, String value2) {
      addCriterion("task_content not between", value1, value2, "taskContent");
      return (Criteria) this;
    }

    public Criteria andSubmitIsNull() {
      addCriterion("submit is null");
      return (Criteria) this;
    }

    public Criteria andSubmitIsNotNull() {
      addCriterion("submit is not null");
      return (Criteria) this;
    }

    public Criteria andSubmitEqualTo(Boolean value) {
      addCriterion("submit =", value, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitNotEqualTo(Boolean value) {
      addCriterion("submit <>", value, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitGreaterThan(Boolean value) {
      addCriterion("submit >", value, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitGreaterThanOrEqualTo(Boolean value) {
      addCriterion("submit >=", value, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitLessThan(Boolean value) {
      addCriterion("submit <", value, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitLessThanOrEqualTo(Boolean value) {
      addCriterion("submit <=", value, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitIn(List<Boolean> values) {
      addCriterion("submit in", values, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitNotIn(List<Boolean> values) {
      addCriterion("submit not in", values, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitBetween(Boolean value1, Boolean value2) {
      addCriterion("submit between", value1, value2, "submit");
      return (Criteria) this;
    }

    public Criteria andSubmitNotBetween(Boolean value1, Boolean value2) {
      addCriterion("submit not between", value1, value2, "submit");
      return (Criteria) this;
    }

    public Criteria andStartTimeIsNull() {
      addCriterion("start_time is null");
      return (Criteria) this;
    }

    public Criteria andStartTimeIsNotNull() {
      addCriterion("start_time is not null");
      return (Criteria) this;
    }

    public Criteria andStartTimeEqualTo(Date value) {
      addCriterion("start_time =", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeNotEqualTo(Date value) {
      addCriterion("start_time <>", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeGreaterThan(Date value) {
      addCriterion("start_time >", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("start_time >=", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeLessThan(Date value) {
      addCriterion("start_time <", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeLessThanOrEqualTo(Date value) {
      addCriterion("start_time <=", value, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeIn(List<Date> values) {
      addCriterion("start_time in", values, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeNotIn(List<Date> values) {
      addCriterion("start_time not in", values, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeBetween(Date value1, Date value2) {
      addCriterion("start_time between", value1, value2, "startTime");
      return (Criteria) this;
    }

    public Criteria andStartTimeNotBetween(Date value1, Date value2) {
      addCriterion("start_time not between", value1, value2, "startTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeIsNull() {
      addCriterion("end_time is null");
      return (Criteria) this;
    }

    public Criteria andEndTimeIsNotNull() {
      addCriterion("end_time is not null");
      return (Criteria) this;
    }

    public Criteria andEndTimeEqualTo(Date value) {
      addCriterion("end_time =", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeNotEqualTo(Date value) {
      addCriterion("end_time <>", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeGreaterThan(Date value) {
      addCriterion("end_time >", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("end_time >=", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeLessThan(Date value) {
      addCriterion("end_time <", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeLessThanOrEqualTo(Date value) {
      addCriterion("end_time <=", value, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeIn(List<Date> values) {
      addCriterion("end_time in", values, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeNotIn(List<Date> values) {
      addCriterion("end_time not in", values, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeBetween(Date value1, Date value2) {
      addCriterion("end_time between", value1, value2, "endTime");
      return (Criteria) this;
    }

    public Criteria andEndTimeNotBetween(Date value1, Date value2) {
      addCriterion("end_time not between", value1, value2, "endTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIsNull() {
      addCriterion("create_time is null");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIsNotNull() {
      addCriterion("create_time is not null");
      return (Criteria) this;
    }

    public Criteria andCreateTimeEqualTo(Date value) {
      addCriterion("create_time =", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotEqualTo(Date value) {
      addCriterion("create_time <>", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeGreaterThan(Date value) {
      addCriterion("create_time >", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("create_time >=", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeLessThan(Date value) {
      addCriterion("create_time <", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
      addCriterion("create_time <=", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIn(List<Date> values) {
      addCriterion("create_time in", values, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotIn(List<Date> values) {
      addCriterion("create_time not in", values, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeBetween(Date value1, Date value2) {
      addCriterion("create_time between", value1, value2, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
      addCriterion("create_time not between", value1, value2, "createTime");
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