import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

import base from "@/store/base";
import cluster from "@/store/cluster";

export default new Vuex.Store({
    modules:{
        base,cluster
    }
})