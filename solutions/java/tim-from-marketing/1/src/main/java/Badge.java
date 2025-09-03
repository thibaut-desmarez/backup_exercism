class Badge {

    public String print(Integer id, String name, String department) {
        if(id != null) {
            return "[" + id + "] - " + name + " - " + (department == null ? "OWNER" : department.toUpperCase());
        }
        else{
            return name + " - " + (department == null ? "OWNER" : department.toUpperCase()) ;
        }
    }


}
