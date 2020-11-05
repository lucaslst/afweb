import Vue from 'vue'
import VueRouter from 'vue-router'
import Apartamento from '../views/Apartamento.vue'
import Editar from '../views/Editar.vue'
import Excluir from '../views/Excluir.vue'
import ListarQuantidade from '../views/ListarQuantidade.vue'
import ListarEndereco from '../views/ListarEndereco.vue'
import ListarValorAluguel from '../views/ListarValorAluguel.vue'
import ListarMNAluguel from '../views/ListarMNAluguel.vue'
import ListarAluguelCond from '../views/ListarAluguelCond.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Apartamento',
    component: Apartamento
  },
  {
    path: '/editar',
    name: 'Editar',
    component: Editar
  },
  {
    path: '/excluir',
    name: 'Excluir',
    component: Excluir
  },
  {
    path: '/listarquantidade',
    name: 'ListarQuantidade',
    component: ListarQuantidade
  },
  {
    path: '/listarendereco',
    name: 'ListarEndereco',
    component: ListarEndereco
  },
  {
    path: '/listarvaloraluguel',
    name: 'ListarValorAluguel',
    component: ListarValorAluguel
  },
  {
    path: '/listarmnaluguel',
    name: 'ListarMNAluguel',
    component: ListarMNAluguel
  },
  {
    path: '/listaraluguelcond',
    name: 'ListarAluguelCond',
    component: ListarAluguelCond
  },
  { path: '*', redirect: '/' } 

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
