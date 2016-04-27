namespace RaceConditionTest
{
    partial class RaceCondition
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle13 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle14 = new System.Windows.Forms.DataGridViewCellStyle();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.checkBackground = new System.Windows.Forms.CheckBox();
            this.btnCreateThread = new System.Windows.Forms.Button();
            this.txtThreadName = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.listMonitor = new System.Windows.Forms.TextBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.gridKiller = new System.Windows.Forms.DataGridView();
            this.btnStopAll = new System.Windows.Forms.Button();
            this.btnPause = new System.Windows.Forms.Button();
            this.btnKill = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this._console = new System.Windows.Forms.TextBox();
            this.clockMonitor = new System.Windows.Forms.Timer(this.components);
            this.clockKiller = new System.Windows.Forms.Timer(this.components);
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.gridKiller)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.checkBackground);
            this.groupBox1.Controls.Add(this.btnCreateThread);
            this.groupBox1.Controls.Add(this.txtThreadName);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.ForeColor = System.Drawing.Color.White;
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(200, 90);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "New Thread";
            // 
            // checkBackground
            // 
            this.checkBackground.AutoSize = true;
            this.checkBackground.Location = new System.Drawing.Point(9, 60);
            this.checkBackground.Name = "checkBackground";
            this.checkBackground.Size = new System.Drawing.Size(84, 17);
            this.checkBackground.TabIndex = 3;
            this.checkBackground.Text = "Background";
            this.checkBackground.UseVisualStyleBackColor = true;
            // 
            // btnCreateThread
            // 
            this.btnCreateThread.ForeColor = System.Drawing.Color.Black;
            this.btnCreateThread.Location = new System.Drawing.Point(119, 54);
            this.btnCreateThread.Name = "btnCreateThread";
            this.btnCreateThread.Size = new System.Drawing.Size(75, 23);
            this.btnCreateThread.TabIndex = 2;
            this.btnCreateThread.Text = "Create";
            this.btnCreateThread.UseVisualStyleBackColor = true;
            this.btnCreateThread.Click += new System.EventHandler(this.btnCreateThread_Click);
            // 
            // txtThreadName
            // 
            this.txtThreadName.Location = new System.Drawing.Point(47, 28);
            this.txtThreadName.Name = "txtThreadName";
            this.txtThreadName.Size = new System.Drawing.Size(147, 20);
            this.txtThreadName.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 31);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Name";
            // 
            // listMonitor
            // 
            this.listMonitor.BackColor = System.Drawing.Color.DimGray;
            this.listMonitor.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.listMonitor.ForeColor = System.Drawing.Color.Gold;
            this.listMonitor.Location = new System.Drawing.Point(218, 41);
            this.listMonitor.Multiline = true;
            this.listMonitor.Name = "listMonitor";
            this.listMonitor.Size = new System.Drawing.Size(302, 257);
            this.listMonitor.TabIndex = 0;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.gridKiller);
            this.groupBox3.Controls.Add(this.btnStopAll);
            this.groupBox3.Controls.Add(this.btnPause);
            this.groupBox3.Controls.Add(this.btnKill);
            this.groupBox3.ForeColor = System.Drawing.Color.White;
            this.groupBox3.Location = new System.Drawing.Point(12, 108);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(200, 191);
            this.groupBox3.TabIndex = 3;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Thread Killer";
            // 
            // gridKiller
            // 
            this.gridKiller.AllowUserToAddRows = false;
            this.gridKiller.AllowUserToDeleteRows = false;
            dataGridViewCellStyle13.ForeColor = System.Drawing.Color.Black;
            dataGridViewCellStyle13.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle13.SelectionForeColor = System.Drawing.Color.White;
            this.gridKiller.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle13;
            this.gridKiller.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.ColumnHeader;
            this.gridKiller.BackgroundColor = System.Drawing.Color.White;
            this.gridKiller.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.gridKiller.Location = new System.Drawing.Point(6, 19);
            this.gridKiller.Name = "gridKiller";
            this.gridKiller.ReadOnly = true;
            dataGridViewCellStyle14.ForeColor = System.Drawing.Color.Black;
            this.gridKiller.RowsDefaultCellStyle = dataGridViewCellStyle14;
            this.gridKiller.RowTemplate.DefaultCellStyle.ForeColor = System.Drawing.Color.Black;
            this.gridKiller.RowTemplate.ReadOnly = true;
            this.gridKiller.Size = new System.Drawing.Size(188, 137);
            this.gridKiller.TabIndex = 4;
            // 
            // btnStopAll
            // 
            this.btnStopAll.ForeColor = System.Drawing.Color.Black;
            this.btnStopAll.Location = new System.Drawing.Point(132, 162);
            this.btnStopAll.Name = "btnStopAll";
            this.btnStopAll.Size = new System.Drawing.Size(62, 23);
            this.btnStopAll.TabIndex = 3;
            this.btnStopAll.Text = "Stop All";
            this.btnStopAll.UseVisualStyleBackColor = true;
            this.btnStopAll.Click += new System.EventHandler(this.btnStopAll_Click);
            // 
            // btnPause
            // 
            this.btnPause.ForeColor = System.Drawing.Color.Black;
            this.btnPause.Location = new System.Drawing.Point(6, 162);
            this.btnPause.Name = "btnPause";
            this.btnPause.Size = new System.Drawing.Size(41, 23);
            this.btnPause.TabIndex = 2;
            this.btnPause.Text = " | | ";
            this.btnPause.UseVisualStyleBackColor = true;
            this.btnPause.Click += new System.EventHandler(this.btnPause_Click);
            // 
            // btnKill
            // 
            this.btnKill.ForeColor = System.Drawing.Color.Black;
            this.btnKill.Location = new System.Drawing.Point(69, 162);
            this.btnKill.Name = "btnKill";
            this.btnKill.Size = new System.Drawing.Size(57, 23);
            this.btnKill.TabIndex = 1;
            this.btnKill.Text = "Kill";
            this.btnKill.UseVisualStyleBackColor = true;
            this.btnKill.Click += new System.EventHandler(this.btnKill_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(755, 12);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(91, 23);
            this.btnClear.TabIndex = 2;
            this.btnClear.Text = "Clear Console";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // _console
            // 
            this._console.BackColor = System.Drawing.Color.DimGray;
            this._console.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this._console.ForeColor = System.Drawing.Color.Lime;
            this._console.Location = new System.Drawing.Point(526, 41);
            this._console.Multiline = true;
            this._console.Name = "_console";
            this._console.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this._console.Size = new System.Drawing.Size(320, 258);
            this._console.TabIndex = 1;
            this._console.TextChanged += new System.EventHandler(this._console_TextChanged);
            // 
            // clockMonitor
            // 
            this.clockMonitor.Enabled = true;
            this.clockMonitor.Interval = 50;
            this.clockMonitor.Tick += new System.EventHandler(this.clock_Tick);
            // 
            // clockKiller
            // 
            this.clockKiller.Enabled = true;
            this.clockKiller.Interval = 3000;
            this.clockKiller.Tick += new System.EventHandler(this.clockKiller_Tick);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(526, 21);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(45, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Console";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(218, 21);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(42, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Monitor";
            // 
            // RaceCondition
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DimGray;
            this.ClientSize = new System.Drawing.Size(858, 310);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.listMonitor);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this._console);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "RaceCondition";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
            this.Text = "RaceCondition";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.gridKiller)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btnCreateThread;
        private System.Windows.Forms.TextBox txtThreadName;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.CheckBox checkBackground;
        private System.Windows.Forms.TextBox listMonitor;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button btnStopAll;
        private System.Windows.Forms.Button btnPause;
        private System.Windows.Forms.Button btnKill;
        private System.Windows.Forms.TextBox _console;
        private System.Windows.Forms.Timer clockMonitor;
        private System.Windows.Forms.Timer clockKiller;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.DataGridView gridKiller;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
    }
}