package tarefa.tarefa4.Model;

public class Gerente extends Funcionario{
    private double salarioBase;
    private double bonus;

    public Gerente(String nome, String matricula) {
        super(nome, matricula);
    }

    public Gerente(String nome, String matricula, double salarioBase, double bonus) {
        super(nome, matricula);
        this.salarioBase = salarioBase;
        this.bonus = bonus;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario(){
        return this.getSalarioBase() + this.getBonus();
    }

    @Override
    public void realizarTarefa(){
        System.out.println("Gerente " + this.getNome() + " esta gerenciando a equipe.");
    }

}
