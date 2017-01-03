package com.rzx.ssm.entity;

public class TestTable {
    private Integer id;

    private String test1;

    private String test2;

    private String test3;

    private String test4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1 == null ? null : test1.trim();
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2 == null ? null : test2.trim();
    }

    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3 == null ? null : test3.trim();
    }

    public String getTest4() {
        return test4;
    }

    public void setTest4(String test4) {
        this.test4 = test4 == null ? null : test4.trim();
    }

	public TestTable(Integer id, String test1) {
		super();
		this.id = id;
		this.test1 = test1;
	}

	public TestTable(String test1) {
		super();
		this.test1 = test1;
	}

	public TestTable(String test1, String test2, String test3, String test4) {
		super();
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
		this.test4 = test4;
	}

	public TestTable() {
		super();
	}

	public TestTable(Integer id, String test1, String test2, String test3, String test4) {
		super();
		this.id = id;
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
		this.test4 = test4;
	}

	@Override
	public String toString() {
		return "TestTable [id=" + id + ", test1=" + test1 + ", test2=" + test2 + ", test3=" + test3 + ", test4=" + test4
				+ "]";
	}
}