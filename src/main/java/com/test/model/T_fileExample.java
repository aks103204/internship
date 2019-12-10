package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class T_fileExample {

  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public T_fileExample() {
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

    public Criteria andFnoIsNull() {
      addCriterion("fno is null");
      return (Criteria) this;
    }

    public Criteria andFnoIsNotNull() {
      addCriterion("fno is not null");
      return (Criteria) this;
    }

    public Criteria andFnoEqualTo(Integer value) {
      addCriterion("fno =", value, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoNotEqualTo(Integer value) {
      addCriterion("fno <>", value, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoGreaterThan(Integer value) {
      addCriterion("fno >", value, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoGreaterThanOrEqualTo(Integer value) {
      addCriterion("fno >=", value, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoLessThan(Integer value) {
      addCriterion("fno <", value, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoLessThanOrEqualTo(Integer value) {
      addCriterion("fno <=", value, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoIn(List<Integer> values) {
      addCriterion("fno in", values, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoNotIn(List<Integer> values) {
      addCriterion("fno not in", values, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoBetween(Integer value1, Integer value2) {
      addCriterion("fno between", value1, value2, "fno");
      return (Criteria) this;
    }

    public Criteria andFnoNotBetween(Integer value1, Integer value2) {
      addCriterion("fno not between", value1, value2, "fno");
      return (Criteria) this;
    }

    public Criteria andFilenameIsNull() {
      addCriterion("filename is null");
      return (Criteria) this;
    }

    public Criteria andFilenameIsNotNull() {
      addCriterion("filename is not null");
      return (Criteria) this;
    }

    public Criteria andFilenameEqualTo(String value) {
      addCriterion("filename =", value, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameNotEqualTo(String value) {
      addCriterion("filename <>", value, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameGreaterThan(String value) {
      addCriterion("filename >", value, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameGreaterThanOrEqualTo(String value) {
      addCriterion("filename >=", value, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameLessThan(String value) {
      addCriterion("filename <", value, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameLessThanOrEqualTo(String value) {
      addCriterion("filename <=", value, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameLike(String value) {
      addCriterion("filename like", value, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameNotLike(String value) {
      addCriterion("filename not like", value, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameIn(List<String> values) {
      addCriterion("filename in", values, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameNotIn(List<String> values) {
      addCriterion("filename not in", values, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameBetween(String value1, String value2) {
      addCriterion("filename between", value1, value2, "filename");
      return (Criteria) this;
    }

    public Criteria andFilenameNotBetween(String value1, String value2) {
      addCriterion("filename not between", value1, value2, "filename");
      return (Criteria) this;
    }

    public Criteria andFiletypeIsNull() {
      addCriterion("filetype is null");
      return (Criteria) this;
    }

    public Criteria andFiletypeIsNotNull() {
      addCriterion("filetype is not null");
      return (Criteria) this;
    }

    public Criteria andFiletypeEqualTo(String value) {
      addCriterion("filetype =", value, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeNotEqualTo(String value) {
      addCriterion("filetype <>", value, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeGreaterThan(String value) {
      addCriterion("filetype >", value, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeGreaterThanOrEqualTo(String value) {
      addCriterion("filetype >=", value, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeLessThan(String value) {
      addCriterion("filetype <", value, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeLessThanOrEqualTo(String value) {
      addCriterion("filetype <=", value, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeLike(String value) {
      addCriterion("filetype like", value, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeNotLike(String value) {
      addCriterion("filetype not like", value, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeIn(List<String> values) {
      addCriterion("filetype in", values, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeNotIn(List<String> values) {
      addCriterion("filetype not in", values, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeBetween(String value1, String value2) {
      addCriterion("filetype between", value1, value2, "filetype");
      return (Criteria) this;
    }

    public Criteria andFiletypeNotBetween(String value1, String value2) {
      addCriterion("filetype not between", value1, value2, "filetype");
      return (Criteria) this;
    }

    public Criteria andTimeIsNull() {
      addCriterion("time is null");
      return (Criteria) this;
    }

    public Criteria andTimeIsNotNull() {
      addCriterion("time is not null");
      return (Criteria) this;
    }

    public Criteria andTimeEqualTo(String value) {
      addCriterion("time =", value, "time");
      return (Criteria) this;
    }

    public Criteria andTimeNotEqualTo(String value) {
      addCriterion("time <>", value, "time");
      return (Criteria) this;
    }

    public Criteria andTimeGreaterThan(String value) {
      addCriterion("time >", value, "time");
      return (Criteria) this;
    }

    public Criteria andTimeGreaterThanOrEqualTo(String value) {
      addCriterion("time >=", value, "time");
      return (Criteria) this;
    }

    public Criteria andTimeLessThan(String value) {
      addCriterion("time <", value, "time");
      return (Criteria) this;
    }

    public Criteria andTimeLessThanOrEqualTo(String value) {
      addCriterion("time <=", value, "time");
      return (Criteria) this;
    }

    public Criteria andTimeLike(String value) {
      addCriterion("time like", value, "time");
      return (Criteria) this;
    }

    public Criteria andTimeNotLike(String value) {
      addCriterion("time not like", value, "time");
      return (Criteria) this;
    }

    public Criteria andTimeIn(List<String> values) {
      addCriterion("time in", values, "time");
      return (Criteria) this;
    }

    public Criteria andTimeNotIn(List<String> values) {
      addCriterion("time not in", values, "time");
      return (Criteria) this;
    }

    public Criteria andTimeBetween(String value1, String value2) {
      addCriterion("time between", value1, value2, "time");
      return (Criteria) this;
    }

    public Criteria andTimeNotBetween(String value1, String value2) {
      addCriterion("time not between", value1, value2, "time");
      return (Criteria) this;
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

    public Criteria andOwePernoIsNull() {
      addCriterion("owe_perNo is null");
      return (Criteria) this;
    }

    public Criteria andOwePernoIsNotNull() {
      addCriterion("owe_perNo is not null");
      return (Criteria) this;
    }

    public Criteria andOwePernoEqualTo(String value) {
      addCriterion("owe_perNo =", value, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoNotEqualTo(String value) {
      addCriterion("owe_perNo <>", value, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoGreaterThan(String value) {
      addCriterion("owe_perNo >", value, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoGreaterThanOrEqualTo(String value) {
      addCriterion("owe_perNo >=", value, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoLessThan(String value) {
      addCriterion("owe_perNo <", value, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoLessThanOrEqualTo(String value) {
      addCriterion("owe_perNo <=", value, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoLike(String value) {
      addCriterion("owe_perNo like", value, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoNotLike(String value) {
      addCriterion("owe_perNo not like", value, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoIn(List<String> values) {
      addCriterion("owe_perNo in", values, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoNotIn(List<String> values) {
      addCriterion("owe_perNo not in", values, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoBetween(String value1, String value2) {
      addCriterion("owe_perNo between", value1, value2, "owePerno");
      return (Criteria) this;
    }

    public Criteria andOwePernoNotBetween(String value1, String value2) {
      addCriterion("owe_perNo not between", value1, value2, "owePerno");
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