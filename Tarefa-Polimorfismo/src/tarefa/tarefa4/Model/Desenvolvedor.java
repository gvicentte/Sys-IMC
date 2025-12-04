package tarefa.tarefa4.Model;

public class Desenvolvedor extends Funcionario{
    private double salarioBase;
    private int anosExperiencia;
    private String linguagemPreferida;

    public Desenvolvedor() {
    }

    public Desenvolvedor(String nome, String matricula, double salarioBase, int anosExperiencia, String linguagemPreferida) {
        super(nome, matricula);
        this.salarioBase = salarioBase;
        this.anosExperiencia = anosExperiencia;
        this.linguagemPreferida = linguagemPreferida;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getLinguagemPreferida() {
        return linguagemPreferida;
    }

    public void setLinguagemPreferida(String linguagemPreferida) {
        this.linguagemPreferida = linguagemPreferida;
    }

    @Override
    public double calcularSalario(){
        return this.getSalarioBase() + (this.getSalarioBase() * ((double) 10 * this.getAnosExperiencia() /100));
    }

    @Override
    public void realizarTarefa(){
        System.out.println("Desenvolvedor " + this.getNome() + " esta codificando em " + this.getLinguagemPreferida() + ".");
    }

}
