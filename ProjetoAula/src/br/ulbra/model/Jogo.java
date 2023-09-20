
package br.ulbra.model;

/**
 *
 * @author Érica Yasmin
 */
public class Jogo {
    private int pk_jogo;
    private String nomeJogo;
    private String generoJogo;
    private String produtoraJogo;
    private String dataLanJogo;
    private String classfiJogo;

    public int getPk_jogo() {
        return pk_jogo;
    }

    public void setPk_Jogo(int pk_jogo) {
        this.pk_jogo = pk_jogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getGeneroJogo() {
        return generoJogo;
    }

    public void setGeneroJogo(String generoJogo) {
        this.generoJogo = generoJogo;
    }

    public String getProdutoraJogo() {
        return produtoraJogo;
    }

    public void setProdutoraJogo(String produtoraJogo) {
        this.produtoraJogo = produtoraJogo;
    }

    public String getDataLanJogo() {
        return dataLanJogo;
    }

    public void setDataLanJogo(String dataLanJogo) {
        this.dataLanJogo = dataLanJogo;
    }

    public String getClassfiJogo() {
        return classfiJogo;
    }

    public void setClassfiJogo(String classfiJogo) {
        this.classfiJogo = classfiJogo;
    }

    @Override
    public String toString(){
        return "Jogo {"+ "pk_jogo="+pk_jogo+", nomeJogo="+nomeJogo+", generoJogo="+generoJogo
                +", produtoraJogo="+produtoraJogo+", dataLanJogo="+dataLanJogo
                +", classfiJogo="+classfiJogo + '}';
    }
}
//(nomeJogo, generoJogo, produtoraJogo, dataLanJogo, classfiJogo)
