<?php

use models\Business\BaseBLL;

class TerminalBLL extends BaseBLL{
    
    public function __construct(){
        $this->nomeEntidade = 'models\Entity\Parada';
        parent::__construct();
    }
}