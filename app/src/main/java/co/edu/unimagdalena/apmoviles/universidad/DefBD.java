package co.edu.unimagdalena.apmoviles.universidad;


    public class DefBD {

        public static final String nameDb = "Universidad";
        public static final String tabla_est = "estudiante";
        public static final String col_codigo = "codigo";
        public static final String col_nombre = "nombre";
        public static final String col_programa = "programa";

        public static final String create_tabla_est = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_est + " ( " +
                DefBD.col_codigo + " text primary key," +
                DefBD.col_nombre + " text," +
                DefBD.col_programa + " text" +
                ");";


}
