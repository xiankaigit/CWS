import axios from "axios";

export default {
    namespaced: true,
    actions: {
        getItConf(context, itId) {
            context.commit("getItConf", itId)
        },
        saveItConf(context,itConf){
            context.commit("saveItConf", itConf)
        },
        getIt(context, kind) {
            context.commit("getIt", kind)
        },
        saveIt(context,data){
            context.commit("saveIt", data)
        },
        delIt(context,delData){
            context.commit("delIt", delData)
        },
        delItConf(context,delConfData){
            context.commit("delItConf", delConfData)
        }

    },
    mutations: {
        delItConf(state,delConfData){
            axios.post("/cws/rest/cluster/it/conf/delete", {
                data:{
                    id: delConfData.id
                }
            }).then(
                    response => {
                        let code = response.data.code;
                        if(code == 1){
                            state.itConf.splice(delConfData.index, 1);
                        } else
                            this._vm.$message.error('失败: ' + response.data.msg);
                    },
                    error => {
                        this._vm.$message.error('执行器保存失败 : 服务器内部异常');
                    }
            )
        },
        saveItConf(state,itConf){
            let index = itConf.index
            if(index != undefined)
                delete itConf.index;
            axios.post("/cws/rest/cluster/it/conf/save", {
                'data':itConf
            }).then(
                    response => {
                        var code = response.data.code;
                        if(code == 1){
                            if(index == undefined)
                                state.itConf.unshift(response.data.data);
                            else
                                state.itConf.splice(index,index,response.data.data)
                        } else
                            this._vm.$message.error('失败: ' + response.data.msg);
                    },
                    error => {
                        this._vm.$message.error('执行器保存失败 : 服务器内部异常');
                    }
            )
        },
        delIt(state,delData){
            axios.post("/cws/rest/cluster/it/delete", {
                data:{
                    id: delData.id
                }
            }).then(
                    response => {
                        let code = response.data.code;
                        if(code == 1){
                            state.it.splice(delData.index, 1);
                        } else
                            this._vm.$message.error('失败: ' + response.data.msg);
                    },
                    error => {
                        this._vm.$message.error('执行器保存失败 : 服务器内部异常');
                    }
            )
        },
        saveIt(state, data) {
            axios.post("/cws/rest/cluster/it/save", {
                data
            }).then(
                    response => {
                        let code = response.data.code;
                        if(code == 1){
                            state.it.unshift(response.data.data);
                            this._vm.$message({
                                message: '成功: 你可以点击执行器对相关参数进行配置啦！',
                                type: 'success'
                            });
                        } else
                            this._vm.$message.error('失败: ' + response.data.msg);
                    },
                    error => {
                        this._vm.$message.error('执行器保存失败 : 服务器内部异常');
                    }
            )
        },
        getItConf(state, itId) {
            axios.post("/cws/rest/cluster/it/conf", {
                data: {
                    itId: itId
                }
            }).then(
                    response => {
                        var code = response.data.code;
                        if(code == 1){
                            state.itConf=response.data.data
                        } else
                            this._vm.$message.error('失败: ' + response.data.msg);
                    },
                    error => {
                        console.info(error)
                        this._vm.$message.error('获取配置信息失败 : 服务器内部异常');
                    }
            )
        },
        getIt(state,kind){
            axios.post("/cws/rest/cluster/it", {
                data: {
                    kind
                }
            }).then(
                    response => {
                        var code = response.data.code;
                        if(code == 1){
                            state.it=response.data.data
                        } else
                           this._vm.$message.error('失败: ' + response.data.msg);
                    },
                    error => {
                        this._vm.$message.error('获取执行器失败 : 服务器内部异常');
                    }
            )
        }
    },
    state: {
        itConf:[],
        it:[]
    },
    getters: {
        getItConf(state) {
            return state.itConf
        }
    }
}