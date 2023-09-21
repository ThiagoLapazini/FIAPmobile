import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfiapreciclagem.databinding.LocaisBinding
import com.example.appfiapreciclagem.model.PontosColeta

class LocalAdapter(private val context: Context, private val localList: MutableList<PontosColeta>) :
    RecyclerView.Adapter<LocalAdapter.PontosColetaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PontosColetaViewHolder {
        val pontosList = LocaisBinding.inflate(LayoutInflater.from(context), parent, false)
        return PontosColetaViewHolder(pontosList)
    }

    override fun getItemCount() = localList.size

    override fun onBindViewHolder(holder: PontosColetaViewHolder, position: Int) {
        val local = localList[position]
        holder.txtnomeLocal.text = local.localNome
        holder.txtdescricao.text = local.localDescricao
        holder.txtdistance.text = String.format("${local.distance} KM's de distância")
    }

    inner class PontosColetaViewHolder(binding: LocaisBinding) : RecyclerView.ViewHolder(binding.root) {
        val txtnomeLocal = binding.nomeLocal
        val txtdescricao = binding.descricaoLocal
        val txtdistance = binding.distance
    }
}