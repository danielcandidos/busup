<?php

use models\Entity\Parada;
use models\Business\ParadaBLL;

class Paradas extends CI_Controller{
    
    public function index(){
        
        $paradasBLL = new ParadaBLL();
        
        $paradas = $paradasBLL->buscarTodos();
        $dados = array();
        $dados["paradas"] = array();
        
        
        foreach ($paradas as $parada){
            $row = array();
            $row["numero"] = $parada->getNumero();
            $row["latitude"] = $parada->getLatitude();
            $row["longitude"] = $parada->getLongitude();
            array_push($dados["paradas"], $row);
            
        }
        
        print json_encode($dados);
    }
    
}

