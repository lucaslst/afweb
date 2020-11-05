<template>
  <div>
    <div>
    <h1> AF - WEB </h1>
    <p> Aluno: Lucas Lima Sousa Torres </p>

        <button @click="cadastrar"> Cadastro de Apartamento</button>
        <button @click="editar"> Editar Apartamento</button>
        <button @click="excluir"> Excluir Arpatamento</button>
        <button @click="listarQuantidade"> Buscar por Quantidade</button>
        <button @click="listarEndereco"> Buscar por Edereço</button>
        <button @click="listarValorAluguel"> Buscar por Valor de Aluguel (Menor)</button>
        <button @click="listarMNAluguel"> Buscar por Valor de Aluguel (Maior e Menor)</button>
        <button @click="listarAluguelCond"> Buscar por Valor de Aluguel e Condomínio (Maior e Menor)</button><br /><br />

    <h1> Cadastro de Apartamento </h1>

  </div>

    <div>
        Endereço: <input type="text" name="" id="endereco" v-model="endereco" /><br /><br />
        Quantidade de Quartos: <input type="text" name="" id="qtdquartos" v-model="qtdquartos" /><br /><br />
        Quantidade de Vagas de Garagem: <input type="text" name="" id="qtdvagasgaragem" v-model="qtdvagasgaragem" /><br /><br />
        Valor de Aluguel: <input type="text" name="" id="valoraluguel" v-model="valoraluguel" /><br /><br />
        Valor de Condomínio: <input type="text" name="" id="valorcondominio" v-model="valorcondominio" /><br /><br />
        Data de Postagem:
        <input type="date" name="" id="datapostagem" v-model="datapostagem" /><br /><br />
       
        <button @click="postApartamento"> Cadastrar Apartamento </button><br /><br />
        <button @click="exibirApartamentos"> Exibir Apartamentos </button><br /><br />
        
    </div>
    <div>
        <ul>
      <li v-for="apartamento in apartamentos" :key="apartamento.id">
        <div>
          <div>
            <table border="2" class="table table-dark">
              <tr>
                <td>ID:</td>
                <td>Endereço:</td>
                <td>Quantidade de Quartos:</td>
                <td>Quantidade de Vagas de Garagem:</td>
                <td>Valor de Aluguel:</td>
                <td>Valor de Condomínio:</td>
                <td>Data de Postagem:</td>
              </tr>

              <tr>
                <td>{{ apartamento.id }}</td>
                <td>{{ apartamento.endereco }}</td>
                <td>{{ apartamento.qtdquartos }}</td>
                <td>{{ apartamento.qtdvagasgaragem }}</td>
                <td>{{ apartamento.valoraluguel }}</td>
                <td>{{ apartamento.valorcondominio }}</td>
                <td>{{ apartamento.datapostagem }}</td>
              </tr>
            </table>
          </div>    
  </div>
    <hr />
      </li>
    </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Apartamento",
  data() {
    return {
      endereco: "",
      qtdquartos: "",
      qtdagasgaragem: "",
      valoraluguel: "",
      valorcondominio: "",
      datapostagem: "",
      apartamento: {},
      apartamentos: [],
      baseURI: "http://localhost:8080/api/apartamentos",
    };
  },
  methods: {
    cadastrar() {
     this.$router.push({ name: "Apartamento"}).catch(()=>{});
   },
   editar() {
     this.$router.push({ name: "Editar"}).catch(()=>{});
   },
   excluir() {
     this.$router.push({ name: "Excluir"}).catch(()=>{});
   },
   listarQuantidade() {
     this.$router.push({ name: "ListarQuantidade"}).catch(()=>{});
   },
   listarEndereco() {
     this.$router.push({ name: "ListarEndereco"}).catch(()=>{});
   },
   listarValorAluguel() {
     this.$router.push({ name: "ListarValorAluguel"}).catch(()=>{});
   },
   listarMNAluguel() {
     this.$router.push({ name: "ListarMNAluguel"}).catch(()=>{});
   },
   listarAluguelCond() {
     this.$router.push({ name: "ListarAluguelCond"}).catch(()=>{});
   },

    exibirApartamentos: function() {
      this.$http.get(this.baseURI).then((result) => {
        this.apartamentos = result.data;
      });
    },
    postApartamento: function() {
      let obj = {
        endereco: this.endereco,
        qtdquartos: this.qtdquartos,
        qtdvagasgaragem: this.qtdvagasgaragem,
        valoraluguel: this.valoraluguel,
        valorcondominio: this.valorcondominio,
        datapostagem: this.datapostagem
      };

      if(this.endereco.length<5)
        alert("Endereço precisa ter no mínimo 5 caracteres!");
      if(this.qtdquartos <= 0)
        alert("Quantide de Quartos precisa ser maior que 0");
      if(this.qtdvagasgaragem <= 0)
        alert("Quantide de Vagas de Garagem precisa ser maior que 0");
      if(this.valoraluguel <= 0)
        alert("Valor de Aluguel precisa ser maior que 0");
      if(this.valorcondominio <= 0)
        alert("Valor de Condomínio precisa ser maior que 0");
     else{
      this.$http.post(this.baseURI, obj).then((result) => {
        console.log(result);
        this.apartamento = result.data;
        alert("Apartamento cadastrado com sucesso!");
      });
     }
    },
  },
};
</script>

 
<style>
  button {
  display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;	
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px white;
  margin-top: 10px;
}

button:hover {background-color: #3e8e41}

button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px white;
  transform: translateY(4px);
  
}
</style>


