package zo.den.testtask4.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import dagger.android.support.AndroidSupportInjection

abstract class MoxyDialogFragment : MvpAppCompatDialogFragment(), BaseView{

    companion object {
        private const val TAG = "MoxyDialogFragment"
    }

    protected abstract val layout: Int

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        onViewAttach(savedInstanceState)
    }

    override fun onDestroyView(){
        onViewDetach()
        super.onDestroyView()
    }

    protected open fun onViewAttach(savedInstanceState: Bundle?){}

    protected open fun onViewDetach(){}
}