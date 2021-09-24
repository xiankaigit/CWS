<template>
    <div>
        <el-row class="editor_bar" style="padding-bottom: 10px">
            <el-tooltip class="item" effect="dark" content="新增配置参数" placement="top">
                <el-button type="primary" icon="el-icon-plus" @click="dialogFormVisible = true" size="small"
                           circle class="tool-bar-item">
                </el-button>
            </el-tooltip>
            <!-- <el-button type="success" icon="el-icon-edit" size="small" round class="tool-bar-item">编辑</el-button>-->
            <!--<el-button type="danger" icon="el-icon-delete" size="small" round class="tool-bar-item">删除</el-button>-->
        </el-row>
        <el-table :data="tableData" stripe highlight-current-row style="height:100%;">
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
                <el-form-item label="属性名:" label-width="120px">
                    <el-input v-model="form.name" style="width: 100%" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="属性值:" label-width="120px">
                    <el-input v-model="form.value" style="width: 100%" autocomplete="off"></el-input>
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
            tabName: '解释器配置',
            dialogFormVisible: false,
            value: '',
            edit: false,
            editRowIdx: '',
            form: {
                id: '',
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
            let delItConfData = {
                'id': rows[index].id,
                'index': index
            }

            this.delItConf(delItConfData);

        },
        reset() {
            this.edit = false
            this.form = {
                id: '',
                name: '',
                value: '',
                remark: ''
            }
            this.editRowIdx = '';
        },
        updateRow(index, rows) {
            this.editRowIdx = index;
            this.edit = true
            this.dialogFormVisible = true
            this.form.id = rows[index].id
            this.form.name = rows[index].name
            this.form.value = rows[index].value
            this.form.remark = rows[index].remark
        },
        closeDialog(flag) {
            this.dialogFormVisible = false
            if (flag) {

                let itConf = {
                    itId: this.$route.params.itId,
                    name: this.form.name,
                    value: this.form.value,
                    remark: this.form.remark
                }

                if (this.edit) {
                    let itConfId = this.form.id
                    itConf.id = itConfId
                    itConf.index = this.editRowIdx
                }
                this.saveItConf(itConf)
                this.reset()
            }
        },
        ...mapActions('cluster', {'getTableData': 'getItConf', 'saveItConf': 'saveItConf', 'delItConf': 'delItConf'})
    },
    activated() {
        if (this.$route.params.itId != undefined)
            this.$store.commit('cluster/getItConf', this.$route.params.itId)
        this.$store.dispatch('base/setValue', {tabName: this.tabName})
    }
}
</script>

<style>

</style>