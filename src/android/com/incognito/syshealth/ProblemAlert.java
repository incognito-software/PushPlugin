package com.incognito.syshealth;

public class ProblemAlert
{
  private String id;
  private String title;
  private String content;
  private long when;
  
  public ProblemAlert(String id, String title, String content, long when)
  {
    this.setId(id);
    this.setTitle(title);
    this.setContent(content);
    this.setWhen(when);
  }

  public String getId()
  {
    return id;
  }
  

  public void setId(String id)
  {
    this.id = id;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public long getWhen()
  {
    return when;
  }

  public void setWhen(long when)
  {
    this.when = when;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }
    
    if (obj == null || obj.getClass() != this.getClass())
    {
      return false;
    }
    
    ProblemAlert problemAlert = (ProblemAlert)obj;
    
    return problemAlert.id.equals(id);
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }
  
  
}
