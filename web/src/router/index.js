import VueRouter from 'vue-router'
import SqlArea from "@/components/task/SqlArea";
import TableManagement from "@/components/meta/TableManagement";
import Interpreter from "@/components/cluster/Interpreter";
import InterpreterConf from "@/components/cluster/InterpreterConf";
import EmptyPage from "@/components/layout/EmptyPage";

export default new VueRouter({
    routes: [
        {
            name: 'sql',
            path: '/sql',
            component: SqlArea
        }, {
            name: 'tableManagement',
            path: '/table',
            component: TableManagement
        }, {
            name: 'interpreter',
            path: '/interpreter',
            component: Interpreter
        },{
            name: 'interpreterConf',
            path: '/interpreter/conf',
            component: InterpreterConf,
        }, {
            name: 'emptyPage',
            path: '/',
            component: EmptyPage
        }
    ]
})

const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(to){
    return VueRouterPush.call(this,to).catch(err => err)
}