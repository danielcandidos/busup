<?php

use models\Business\BaseBLL;

class ParadaBLL extends BaseBLL{
    
    public function __construct(){
        $this->nomeEntidade = 'models\Entity\Parada';
        parent::__construct();
    }
}
