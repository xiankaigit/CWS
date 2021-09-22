import axios from "axios";

export default {
    namespaced: true,
    actions: {
        getItConf(context, name) {
            context.commit("getItConf", name)
        }
    },
    mutations: {
        getItConf(state, name) {
            axios.post("/cws/rest/cluster/it/conf", {
                data: {
                    name: name
                }
            }).then(
                    response => {
                        var code = response.data.code;
                        if(code == 1){
                            state.itConf=response.data.data
                        } else
                            this.$message.error('失败: ' + response.data.msg);
                    },
                    error => {
                        console.info(error)
                        this.$message.error('获取' +name+'配置信息失败 : 服务器内部异常');
                    }
            )
        }
    },
    state: {
        itConf:[]
    },
    getters: {
        getItConf(state) {
            return state.itConf
        }
    }
}