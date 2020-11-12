package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cursoandroidsqlite.R;
import java.util.ArrayList;

import entidades.UsuariosVo;

public class AdapterDatos
        extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos>
        implements View.OnClickListener{

    ArrayList<UsuariosVo> listUsuarios;
    private View.OnClickListener btnModal;

    public AdapterDatos(ArrayList<UsuariosVo> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.txtId.setText(String.valueOf(listUsuarios.get(position).getId()));
        holder.txtNombre.setText(listUsuarios.get(position).getNombre());
        holder.txtDistrito.setText(listUsuarios.get(position).getDistrito());
        holder.txtCorreo.setText(listUsuarios.get(position).getCorreo());
        holder.txtPassword.setText(listUsuarios.get(position).getPassword());

    }

    @Override
    public int getItemCount() {
        return listUsuarios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.btnModal = listener;
    }

    @Override
    public void onClick(View v) {
        if(btnModal!=null){
            btnModal.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txtId, txtNombre, txtDistrito, txtCorreo, txtPassword;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtId = (TextView) itemView.findViewById(R.id.txtId);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtDistrito = (TextView) itemView.findViewById(R.id.txtDistrito);
            txtCorreo = (TextView) itemView.findViewById(R.id.txtCorreo);
            txtPassword = (TextView) itemView.findViewById(R.id.txtPassword);
        }

    }
}
