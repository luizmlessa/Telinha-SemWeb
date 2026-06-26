package br.com.lm.telinha.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
