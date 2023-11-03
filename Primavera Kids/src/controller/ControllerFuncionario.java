package controller;

import model.ModelFuncionario;
import DAO.DAOFuncionario;
import java.util.ArrayList;

/**
*
* @author Carlos
*/
public class ControllerFuncionario {

    private DAOFuncionario daoFuncionario = new DAOFuncionario();

    /**
    * grava Funcionario
    * @param pModelFuncionario
    * @return int
    */
    public int salvarFuncionarioController(ModelFuncionario pModelFuncionario){
        return this.daoFuncionario.salvarFuncionarioDAO(pModelFuncionario);
    }

    /**
    * recupera Funcionario
    * @param pIdFunc
    * @return ModelFuncionario
    */
    public ModelFuncionario getFuncionarioController(int pIdFunc){
        return this.daoFuncionario.getFuncionarioDAO(pIdFunc);
    }

    /**
    * recupera uma lista deFuncionario
    * @param pIdFunc
    * @return ArrayList
    */
    public ArrayList<ModelFuncionario> getListaFuncionarioController(){
        return this.daoFuncionario.getListaFuncionarioDAO();
    }

    /**
    * atualiza Funcionario
    * @param pModelFuncionario
    * @return boolean
    */
    public boolean atualizarFuncionarioController(ModelFuncionario pModelFuncionario){
        return this.daoFuncionario.atualizarFuncionarioDAO(pModelFuncionario);
    }

    /**
    * exclui Funcionario
    * @param pIdFunc
    * @return boolean
    */
    public boolean excluirFuncionarioController(int pIdFunc){
        return this.daoFuncionario.excluirFuncionarioDAO(pIdFunc);
    }
}