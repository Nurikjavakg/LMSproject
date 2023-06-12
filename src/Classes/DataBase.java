package Classes;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

      private List<Group> groups = new ArrayList<>();

      private List<Admin> admins = new ArrayList<>();

      public DataBase(List<Group> groups, List<Admin> admins) {
            this.groups = groups;
            this.admins = admins;
      }

      public List<Group> getGroups() {
            return groups;
      }

      public void setGroups(List<Group> groups) {
            this.groups = groups;
      }

      public List<Admin> getAdmins() {
            return admins;
      }

      public void setAdmins(List<Admin> admins) {
            this.admins = admins;
      }
}

