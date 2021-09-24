<template>
    <div>
        <el-row class="editor_bar" style="padding-bottom: 10px">
            <el-select v-model="value" @change="getTableData(value)" style="width: 180px" size="medium"
                       placeholder="请选择"
                       class="tool-bar-item">
                <el-option
                        v-for="item in itKindsWithAll"
                        :key="item.id"
                        :label="item.name"
                        :value="item.value">
                </el-option>
            </el-select>
            <el-tooltip class="item" effect="dark" content="新增执行器" placement="top">
                <el-button type="primary" icon="el-icon-plus" @click="dialogFormVisible = true" size="small"
                           circle class="tool-bar-item">
                </el-button>
            </el-tooltip>
            <!--<el-button type="success" icon="el-icon-edit" size="small" round class="tool-bar-item">配置</el-button>-->
        </el-row>
        <el-table :data="tableData" stripe highlight-current-row style="height: 100%">
            <el-table-column prop="name" label="名称"></el-table-column>
            <el-table-column prop="kind" label="类型"></el-table-column>
            <el-table-column prop="remark" label="备注"></el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="120">
                <template slot-scope="scope">
                    <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text">移除</el-button>
                    <el-button @click.native.prevent="goToItConf(scope.$index, tableData)" type="text">配置</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="新增执行器" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="名称:" label-width="120px">
                    <el-input v-model="form.name" style="width: 100%" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="类型:" label-width="120px">
                    <el-select v-model="form.kind" style="width: 99%" size="medium" placeholder="请选择"
                               class="tool-bar-item">
                        <el-option
                                v-for="item in itKinds"
                                :key="item.id"
                                :label="item.name"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="备注:" label-width="120px">
                    <el-input v-model="form.remark" style="width: 100%" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="closeDialog(false)">取 消</el-button>
                <el-button type="primary" @click="closeDialog(true)">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
    name: "Interpreter",
    data() {
        return {
            tabName: '解释器',
            dialogFormVisible: false,
            itKinds: [
                {
                    id: 2,
                    name: 'Flink',
                    value: 'Flink'
                }, {
                    id: 3,
                    name: 'Spark',
                    value: 'Spark'
                }],
            itKindsWithAll: [
                {
                    id: 1,
                    name: '所有类型',
                    value: 'all'
                }, {
                    id: 2,
                    name: 'Flink',
                    value: 'Flink'
                }, {
                    id: 3,
                    name: 'Spark',
                    value: 'Spark'
                }],
            value: 'all',
            form: {
                name: 'Flink',
                kind: 'Flink',
                remark: '',
            }
        }
    },
    computed: {
        //cluster: namespace, 各模块在index中注册名称
        //tableData: 映射为computed属性的名称
        //itConf: stete中的key
        ...mapState('cluster', {'tableData': 'it'})
    },
    methods: {
        deleteRow(index, rows) {
            console.info()
            let delData = {
                id: rows[index].id,
                index: index,
            }
            this.delIt(delData)

        },
        goToItConf(index, rows) {
            this.$router.push({
                name:'interpreterConf',
                params:{
                    itId: rows[index].id
                }
            })
        },
        closeDialog(flag) {
            this.dialogFormVisible = false
            if (flag) {
                console.info(this.form)
                let it = {
                    name: this.form.name,
                    kind: this.form.kind,
                    remark: this.form.remark
                }
                this.saveIt(it)
            }
        },
        ...mapActions('cluster', {'getTableData': 'getIt','saveIt':'saveIt','delIt':'delIt'})
    },
    activated() {
        this.$store.dispatch('base/setValue', {tabName: this.tabName})
    },
    mounted() {

        this.$store.dispatch('cluster/getIt', this.value)
    }
}
</script>

<style>

</style>