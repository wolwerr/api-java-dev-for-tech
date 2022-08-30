package com.br.devForTech.ApiAngular.models;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private static List<Empresa> empresas = new ArrayList<>();

    public static List<Empresa> todos(){
        return Empresa.empresas;
    }

    public static void add(Empresa empresa){
        Empresa.empresas.add(empresa);
    }

    public static void set(List<Empresa> empresas){
        Empresa.empresas = empresas;
    }

    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private String razao;
    public String getRazao() {
        return razao;
    }
    public void setRazao(String razao) {
        this.razao = razao;
    }
    private String cnpj;
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    private String cep;
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    private String rua;
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    private String numero;
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    private String bairro;
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    private String cidade;
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    private String estado;
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    private Float valorFrete;
    public Float getValorFrete() {
        return valorFrete;
    }
    public void getValorFrete(Float valorFrete) {
        this.valorFrete = valorFrete;
    }
}
