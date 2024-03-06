package com.hms.entity;

public class Test {
	
		
		private int testId;
		private String test_name;
		private String test_description;
	
		
		public Test() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Test(String test_name,String test_description) {
			super();
			this.test_name = test_name;
			this.test_description =test_description	;		
		}
		
		

		public Test(int testId, String test_name,String test_description) {
			super();
			this.testId = testId;
			this.test_name = test_name;
			this.test_description = test_description;
	
		}



		public int getId() {
			return testId;
		}


		public void setId(int testId) {
			this.testId = testId;
		}


		public String getTestName() {
			return test_name;
		}


		public void setTestName(String test_name) {
			this.test_name = test_name;
		}
		
		public String getTestDescription() {
			return test_description;
		}


		public void setTestDescription(String test_description) {
			this.test_description = test_description;
		}


}
