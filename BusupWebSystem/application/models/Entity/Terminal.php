<?php

namespace models\Entity;
/**
 * @Entity
 * @Table(name="Terminal") 
 **/
class Terminal extends Parada{
    /**
     * @Column(type="string")
     */
    protected $nome;
    
    public function getNome() {
        return $this->nome;
    }

    public function setNome($nome) {
        $this->nome = $nome;
    }


}
