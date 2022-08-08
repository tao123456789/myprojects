package com.example.token.Entity.BO;

import lombok.Data;

@Data
public class usergroupaction {
        private int userid;
        private int groupid;
        private int actionid;


        @Override
        public String toString() {
            return "usergroupaction{" +
                    "userid=" + userid +
                    ", groupid=" + groupid +
                    ", actionid=" + actionid +
                    '}';
        }
}
