package com.hms.entity;

public class Status {


		
			
			private int statusId;
			private String statusName;
			private boolean isLabTest;
		
			
			public Status() {
				super();
				// TODO Auto-generated constructor stub
			}


			public Status(String statusName,boolean isLabTest) {
				super();
				this.statusName = statusName;
				this.isLabTest = isLabTest;
					
			}
			
			

			public Status(int statusId, String statusName,boolean isLabTest) {
				super();
				this.statusId = statusId;
				this.statusName = statusName;
				this.isLabTest = isLabTest;
		
			}



			public int getId() {
				return statusId;
			}


			public void setId(int statusId) {
				this.statusId = statusId;
			}


			public String getStatusName() {
				return statusName;
			}


			public void setStatusName(String statusName) {
				this.statusName = statusName;
			}
			

			public boolean getStatusFlag() {
				return isLabTest;
			}


			public void setStatusFlag(boolean isLabTest) {
				this.isLabTest = isLabTest;
			}
			

}
