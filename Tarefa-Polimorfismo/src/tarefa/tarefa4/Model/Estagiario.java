package tarefa.tarefa4.Model;

public class Estagiario extends Funcionario{
    private double bolsaAuxilio;

    public Estagiario() {
    }

    public Estagiario(String nome, String matricula, double bolsaAuxilio) {
        super(nome, matricula);
        this.bolsaAuxilio = bolsaAuxilio;
    }

    public double getBolsaAuxilio() {
        return bolsaAuxilio;
    }

    public void setBolsaAuxilio(double bolsaAuxilio) {
        this.bolsaAuxilio = bolsaAuxilio;
    }

    @Override
    public double calcularSalario(){
        return this.getBolsaAuxilio();
    }

    @Override
    public void realizarTarefa(){
        System.out.println("Estagiario " + this.getNome() + " esta aprendendo e auxiliando.");
    }

}
