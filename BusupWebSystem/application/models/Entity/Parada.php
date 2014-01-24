<?php

namespace models\Entity;
/**
 * @Entity 
 **/
class Parada extends Ponto{
    /*
     * @Column(type="integer")
     */
    protected $numero;
    /*
     * @Column(type="string")
     */
    protected $endereco;
    
    public function getNumero() {
        return $this->numero;
    }

    public function getEndereco() {
        return $this->endereco;
    }

    public function setNumero($numero) {
        $this->numero = $numero;
    }

    public function setEndereco($endereco) {
        $this->endereco = $endereco;
    }


}

