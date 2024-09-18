package controller;



public class PathVariableController {
    /* Binding a URI template variable to a method parameter using 'name' or 'value' attribute of @PathVariable  */
    @ResponseBody
    public String handler(@PathVariable(name = "name") String name) {
        return "URL parameter name: " + name;
    }
    /* Binding URI template variables to method parameters without using 'name' or 'value' attribute of @PathVariable.   */
    @ResponseBody
    public String handler(@PathVariable String firstName, @PathVariable String lastName) {
        return "URL parameters - <br>"
                + " firstName = " + firstName + " <br>"
                + " lastName = " + lastName;
    }

    /*  If the method parameter type is not String then Spring automatically converts to the appropriate type such as int, long, float, etc.   */
    @ResponseBody
    public String handler(@PathVariable("name") String name,
                          @PathVariable("age") int age,
                          @PathVariable("salary") double salary,
                          @PathVariable("active") boolean active) {
        return "URL parameters - <br>"
                + " name = " + name + " <br>"
                + " age = " + age + " <br>"
                + " salary = " + salary
                + " <br>" + " active = " + active;
    }


    /* Binding all URI template variables to Map  */
    @ResponseBody
    public String handler(@PathVariable Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append("URL parameters - <br>");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.append(entry.getKey() + " = " + entry.getValue() + "<br>");
        }
        return builder.toString();
    }
    /*Binding date and time URL template variable to LocalDate and LocalTime   */
    @ResponseBody
    public String handler(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("date") LocalDate date,
            @DateTimeFormat(pattern = "HH:mm:ss") @PathVariable("time") LocalTime time) {
        return "URL parameters - <br>"
                + " date = " + date + " <br>"
                + " time = " + time;
    }
    /*Binding URI template variable to array and list  */
    @ResponseBody
    public String handler(@PathVariable("country") String[] country,
                          @PathVariable("city") List<String> city) {
        return "URL parameters - <br>"
                + " country = " + Arrays.asList(country) + " <br>"
                + " city = " + city;
    }
}
