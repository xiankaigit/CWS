<template>
    <div>
        <el-row class="editor_bar" style="padding-bottom: 10px">
            <el-tooltip class="item" effect="dark" content="执行" placement="top">
                <el-button class="tool-bar-item" icon="el-icon-s-promotion" size="small" @click="runSql" circle
                           type="primary" plain>
                </el-button>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="格式化" placement="top">
                <el-button class="tool-bar-item" icon="el-icon-brush" circle size="small" @click="format()"
                           type="success"
                           plain>
                </el-button>
            </el-tooltip>
        </el-row>
        <textarea ref="mycode" v-model="code"/>
    </div>
</template>

<script>

import 'codemirror/theme/ambiance.css'
import '../../style/codemirror.css'
import 'codemirror/addon/hint/show-hint.css'

const CodeMirror = require('codemirror/lib/codemirror')
require('codemirror/addon/edit/matchbrackets')
require('codemirror/addon/selection/active-line')
require('codemirror/mode/sql/sql')
require('codemirror/addon/hint/show-hint')
require('codemirror/addon/hint/sql-hint')

import 'codemirror/theme/base16-light.css'
import 'codemirror/lib/codemirror.css'
import 'codemirror/addon/hint/show-hint.css'


import sqlFormatter from 'sql-formatter'
import '../../assets/icon/iconfont.css'
import axios from "axios";


export default {
    name: "SqlEditor",
    data() {
        return {
            code: '',
            editor: null,
            tabName: 'SQL任务'
        };
    },
    methods: {
        format() {
            /* 获取文本编辑器内容*/
            let sqlContent = ''
            sqlContent = this.editor.getValue()
            console.info(sqlContent)
            /* 将sql内容进行格式后放入编辑器中*/
            var fomated_sql = sqlFormatter.format(sqlContent);
            this.editor.setValue(fomated_sql)
        },
        runSql() {
            this.format();
            var sql = this.editor.getValue()
            axios.post("/cws/rest/task/sql", {
                data: {
                    sql: sql
                }
            }).then(
                    response => {
                        console.info(response)
                        var code = response.data.code;
                        if (code == 1)
                            this.$message({
                                message: '成功: ' + response.data.msg,
                                type: 'success'
                            });
                        else
                            console.info("sql this ==>", this)
                        this.$message.error('失败: ' + response.data.msg);
                    },
                    error => {
                        console.info(error)
                        this.$message.error('执行sql失败: 服务器内部异常');
                    }
            )
        }
    },
    activated() {
        this.$store.dispatch('base/setValue', {tabName: this.tabName})
    },
    mounted() {
        this.editor = CodeMirror.fromTextArea(this.$refs.mycode, {
            tabSize: 4,
            mode: "text/x-mysql",
            indentWithTabs: true,
            smartIndent: true,
            matchBrackets: true,
            theme: 'base16-light',
            lineNumbers: true,
            line: true,
            lineWrapping: true,
            value: "请输入sql",
            extraKeys: {
                'Ctrl': 'autocomplete',
                "Ctrl-Space": editor => {
                    editor.showHint();
                }
            },
            hintOptions: {
                completeSingle: false
            }
        });
        this.editor.on("keypress", editor => {
            editor.showHint();
        });
    }
};
</script>

<style scoped>
.sql {
    color: blue;
}

.sql:after {
    content: "sql";
    padding-left: 20px;
    font-style: italic;
    float: right;
    color: gray;
}

.table {
    color: blueviolet;
}

.table:after {
    content: "table";
    padding-left: 20px;
    font-style: italic;
    float: right;
    color: gray;
}

.CodeMirror {
    background-color: black;
    color: black;
}

.cm-s-base16-light {
    background-color: black;
    color: black;
}

.CodeMirror-wrap {
    background-color: black;
    color: black;
}
</style>
