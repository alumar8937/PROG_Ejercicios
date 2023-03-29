public class Tarea implements Comparable<Tarea>{
    public int prioridad;
    public int duracion;
    public Tarea(int prioridad, int duracion) {
        this.prioridad = prioridad;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "P:" + this.prioridad + " D:" + this.duracion;
    }
    
    public int compareTo(Tarea t) {
        if (this.prioridad < t.prioridad) {
            return 1;
        }
        if (this.prioridad == t.prioridad) {
            return this.duracion - t.duracion;
        }
        return -1;
    }
}
