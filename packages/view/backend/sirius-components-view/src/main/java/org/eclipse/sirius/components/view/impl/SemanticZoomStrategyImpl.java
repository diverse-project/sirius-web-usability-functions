/**
 * Copyright (c) 2021, 2023 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *      Obeo - initial API and implementation
 */
package org.eclipse.sirius.components.view.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.sirius.components.view.NodeStyleDescription;
import org.eclipse.sirius.components.view.SemanticZoomStrategy;
import org.eclipse.sirius.components.view.ViewPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Semantic Zoom Strategy</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomStrategyImpl#isActiveStrategy <em>Active
 * Strategy</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomStrategyImpl#getStyleDetailled <em>Style
 * Detailled</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomStrategyImpl#getStyleNormal <em>Style
 * Normal</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.impl.SemanticZoomStrategyImpl#getStyleSummarized <em>Style
 * Summarized</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SemanticZoomStrategyImpl extends MinimalEObjectImpl.Container implements SemanticZoomStrategy {
    /**
     * The default value of the '{@link #isActiveStrategy() <em>Active Strategy</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #isActiveStrategy()
     * @generated
     * @ordered
     */
    protected static final boolean ACTIVE_STRATEGY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isActiveStrategy() <em>Active Strategy</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #isActiveStrategy()
     * @generated
     * @ordered
     */
    protected boolean activeStrategy = ACTIVE_STRATEGY_EDEFAULT;

    /**
     * The cached value of the '{@link #getStyleDetailled() <em>Style Detailled</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStyleDetailled()
     * @generated
     * @ordered
     */
    protected NodeStyleDescription styleDetailled;

    /**
     * The cached value of the '{@link #getStyleNormal() <em>Style Normal</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStyleNormal()
     * @generated
     * @ordered
     */
    protected NodeStyleDescription styleNormal;

    /**
     * The cached value of the '{@link #getStyleSummarized() <em>Style Summarized</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStyleSummarized()
     * @generated
     * @ordered
     */
    protected NodeStyleDescription styleSummarized;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SemanticZoomStrategyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ViewPackage.Literals.SEMANTIC_ZOOM_STRATEGY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isActiveStrategy() {
        return this.activeStrategy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setActiveStrategy(boolean newActiveStrategy) {
        boolean oldActiveStrategy = this.activeStrategy;
        this.activeStrategy = newActiveStrategy;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_STRATEGY__ACTIVE_STRATEGY, oldActiveStrategy, this.activeStrategy));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NodeStyleDescription getStyleDetailled() {
        return this.styleDetailled;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetStyleDetailled(NodeStyleDescription newStyleDetailled, NotificationChain msgs) {
        NodeStyleDescription oldStyleDetailled = this.styleDetailled;
        this.styleDetailled = newStyleDetailled;
        if (this.eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED, oldStyleDetailled, newStyleDetailled);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStyleDetailled(NodeStyleDescription newStyleDetailled) {
        if (newStyleDetailled != this.styleDetailled) {
            NotificationChain msgs = null;
            if (this.styleDetailled != null)
                msgs = ((InternalEObject) this.styleDetailled).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED, null, msgs);
            if (newStyleDetailled != null)
                msgs = ((InternalEObject) newStyleDetailled).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED, null, msgs);
            msgs = this.basicSetStyleDetailled(newStyleDetailled, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED, newStyleDetailled, newStyleDetailled));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NodeStyleDescription getStyleNormal() {
        return this.styleNormal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetStyleNormal(NodeStyleDescription newStyleNormal, NotificationChain msgs) {
        NodeStyleDescription oldStyleNormal = this.styleNormal;
        this.styleNormal = newStyleNormal;
        if (this.eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL, oldStyleNormal, newStyleNormal);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStyleNormal(NodeStyleDescription newStyleNormal) {
        if (newStyleNormal != this.styleNormal) {
            NotificationChain msgs = null;
            if (this.styleNormal != null)
                msgs = ((InternalEObject) this.styleNormal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL, null, msgs);
            if (newStyleNormal != null)
                msgs = ((InternalEObject) newStyleNormal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL, null, msgs);
            msgs = this.basicSetStyleNormal(newStyleNormal, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL, newStyleNormal, newStyleNormal));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NodeStyleDescription getStyleSummarized() {
        return this.styleSummarized;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetStyleSummarized(NodeStyleDescription newStyleSummarized, NotificationChain msgs) {
        NodeStyleDescription oldStyleSummarized = this.styleSummarized;
        this.styleSummarized = newStyleSummarized;
        if (this.eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED, oldStyleSummarized, newStyleSummarized);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStyleSummarized(NodeStyleDescription newStyleSummarized) {
        if (newStyleSummarized != this.styleSummarized) {
            NotificationChain msgs = null;
            if (this.styleSummarized != null)
                msgs = ((InternalEObject) this.styleSummarized).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED, null, msgs);
            if (newStyleSummarized != null)
                msgs = ((InternalEObject) newStyleSummarized).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED, null, msgs);
            msgs = this.basicSetStyleSummarized(newStyleSummarized, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED, newStyleSummarized, newStyleSummarized));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED:
                return this.basicSetStyleDetailled(null, msgs);
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL:
                return this.basicSetStyleNormal(null, msgs);
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED:
                return this.basicSetStyleSummarized(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__ACTIVE_STRATEGY:
                return this.isActiveStrategy();
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED:
                return this.getStyleDetailled();
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL:
                return this.getStyleNormal();
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED:
                return this.getStyleSummarized();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__ACTIVE_STRATEGY:
                this.setActiveStrategy((Boolean) newValue);
                return;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED:
                this.setStyleDetailled((NodeStyleDescription) newValue);
                return;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL:
                this.setStyleNormal((NodeStyleDescription) newValue);
                return;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED:
                this.setStyleSummarized((NodeStyleDescription) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__ACTIVE_STRATEGY:
                this.setActiveStrategy(ACTIVE_STRATEGY_EDEFAULT);
                return;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED:
                this.setStyleDetailled((NodeStyleDescription) null);
                return;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL:
                this.setStyleNormal((NodeStyleDescription) null);
                return;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED:
                this.setStyleSummarized((NodeStyleDescription) null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__ACTIVE_STRATEGY:
                return this.activeStrategy != ACTIVE_STRATEGY_EDEFAULT;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_DETAILLED:
                return this.styleDetailled != null;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_NORMAL:
                return this.styleNormal != null;
            case ViewPackage.SEMANTIC_ZOOM_STRATEGY__STYLE_SUMMARIZED:
                return this.styleSummarized != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (activeStrategy: ");
        result.append(this.activeStrategy);
        result.append(')');
        return result.toString();
    }

} // SemanticZoomStrategyImpl
