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

    <h1> Listar Apartamentos por Valor de Aluguel (Menor e Maior) </h1>
  </div>

  <div>
        Digite o Valor mínimo de Aluguel que deseja visualizar: <input type="text" name="" id="menoraluguel" v-model="menoraluguel" /><br /><br />  
        Digite o Valor máximo de Aluguel que deseja visualizar: <input type="text" name="" id="maioraluguel" v-model="maioraluguel" /><br /><br />

        <button @click="listarMNAluguel"> Listar Apartamentos </button><br /><br />
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
  name: "ListarMNAluguel",
  data() {
    return {
      menoraluguel: "",
      maioraluguel: "",
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
   },listarMNAluguel() {
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
   listarMNAluguel: function() {
    if(this.menoraluguel <= 0 || this.maioraluguel <=0)
        alert("Digite um valor maior que 0!");
    if(this.menoraluguel >= this.maioraluguel)
        alert("Digite corretamente o valor dos campos!")
    else{
      this.$http.get(this.baseURI + "/page2?menoraluguel="+this.menoraluguel+"&maioraluguel="+this.maioraluguel).then((result) => {
        this.apartamentos = result.data;
      })
        .catch(function(error) {
          console.log(error);
        });
    }
    },
    },
};
</script>