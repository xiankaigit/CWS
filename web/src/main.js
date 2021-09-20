import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

//引入ElementUI组件库
import ElementUI from 'element-ui';
//引入ElementUI全部样式
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);
Vue.config.productionTip = false
//vue-codemirror
import VueCodeMirror from 'vue-codemirror'
import 'codemirror/lib/codemirror.css'
Vue.use(VueCodeMirror)
//路由
import VueRouter from 'vue-router'
import router from './router'
Vue.use(VueRouter)
//store
import store from './store'
//axios
import axios from "axios";

import './style/base.css'

new Vue({
  render: h => h(App),
  router: router,
  store
}).$mount('#app')
