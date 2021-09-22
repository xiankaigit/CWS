<template>


    <div>
        <el-row class="editor_bar" style="padding-bottom: 10px">
            <el-select v-model="value" @change="getTableData" size="medium" placeholder="请选择" class="tool-bar-item">
                <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
            <el-button type="primary" icon="el-icon-circle-plus-outline" @click="dialogFormVisible = true" size="small"
                       round class="tool-bar-item">新增
            </el-button>
            <el-button type="success" icon="el-icon-edit" size="small" round class="tool-bar-item">编辑</el-button>
            <el-button type="danger" icon="el-icon-delete" size="small" round class="tool-bar-item">删除</el-button>
        </el-row>
        <el-table :data="tableData" stripe height="300" highlight-current-row style="height:100%; width: 100%">
            <el-table-column prop="name" label="属性名"></el-table-column>
            <el-table-column prop="value" label="属性值"></el-table-column>
            <el-table-column prop="remark" label="备注"></el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="120">
                <template slot-scope="scope">
                    <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text">移除</el-button>
                    <el-button @click.native.prevent="updateRow(scope.$index, tableData)" type="text">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="新增配置项" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="属性名" label-width="120px">
                    <el-input v-model="form.name" style="width: 100%" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="属性值" label-width="120px">
                    <el-input v-model="form.value" style="width: 100%" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="备注" label-width="120px">
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
            tabName: '解释器配置',
            dialogFormVisible: false,
            options: [{
                value: 'flink',
                label: 'flink'
            }],
            value: 'flink',
            form: {
                name: '',
                value: '',
                remark: ''
            }
        }
    },
    computed: {
        //cluster: namespace, 各模块在index中注册名称
        //tableData: 映射为computed属性的名称
        //itConf: stete中的key
        ...mapState('cluster', {'tableData': 'itConf'})
    },
    methods: {
        deleteRow(index, rows) {
            rows.splice(index, 1);
        },
        updateRow(index, rows) {
            console.log(index, rows)
            alert("updateRow")
        },
        closeDialog(flag){
            this.dialogFormVisible = false
            if(flag){
               // save to db
            }
        },
        ...mapActions('cluster', {'getTableData': 'getItConf'})
    },
    mounted() {
        this.$store.dispatch('base/setValue', {tabName: this.tabName})
        this.getTableData(this.value);
    }
}
</script>

<style>

</style>